require 'net/http'
require 'uri'
require 'json'

module Migrate
  class PpgUsers
    attr_reader :user_success_list, :user_error_list

    def initialize()
      @user_success_list = []
      @user_error_list = []
    end


    def migrate_user(org, user, org_admin_status, ppg_org_response_status_code, cii_response_body)
      @admin_check = org_admin_status
      @ppg_status_code = ppg_org_response_status_code
      @cii_body = cii_response_body

      migrate_user_to_ppg(org, user)
    end


    private


    def migrate_user_to_ppg(org, user)
      user_roles = get_user_roles(user)
      identity_provider = get_identity_provider

      if user_roles.present? && identity_provider.present?
        response = send_request_to_ppg('/user-profile', {  user: user, user_roles: user_roles, identity_provider: identity_provider  })

        if response.present? && response[:response].present? && response[:response].code.present?
          if [200, 201, 409].include?(response[:response].code.to_i)
            user_roles_response = 204
            user_roles_response = update_existing_user_roles(user, user_roles, identity_provider) if response[:response].code.to_i == 409
            user_contact_response = add_user_contact(user)
            @user_success_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: true, status: response[:response].code.to_i, update_roles_status: user_roles_response, contact_status: user_contact_response  } # User Migrated or Already Exists.
            return {  response_status_code: response[:response].code.to_i, response_body: nil  }
          else
            @user_error_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: response[:response].code.to_i, status_description: response[:status_description]  } # User Not Migrated.
            return {  response_status_code: response[:response].code.to_i, response_body: nil  }
          end
        else
          @user_error_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: 500, status_description: response[:status_description]  } # User Not Migrated.
          return {  response_status_code: 500, response_body: nil  }
        end
      else
        @user_error_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: 500, status_description: 'Error Getting User Roles or Identity Provider. User Not Creatd in PPG.'  } # User Not Migrated.
        return {  response_status_code: 500, response_body: nil  }
      end
    end


    def get_user_roles(user)
      cii_org_data = JSON.parse(@cii_body)
      response = send_request_to_ppg("/organisation-profile/#{cii_org_data['organisationId']}/roles")

      return nil unless response.present? && response[:response].present? && response[:response].code.present?
      return nil unless (200..201).include?(response[:response].code.to_i) && response[:response].body.present?

      roles_library = JSON.parse(response[:response].body)
      matching_role_ids = []

      user['userRoles'].each do |role|
        matching_roles = roles_library.select { |role_data| role_data['roleKey'] == role['key'] }
        matching_role_ids.concat(matching_roles.map { |role_data| role_data['roleId'] })
      end

      return matching_role_ids if matching_role_ids.present? && matching_role_ids.any?
      nil
    end


    def get_identity_provider
      cii_org_data = JSON.parse(@cii_body)
      response = send_request_to_ppg("/organisation-profile/#{cii_org_data['organisationId']}/identity-providers")

      return nil unless response.present? && response[:response].present? && response[:response].code.present?
      return nil unless (200..201).include?(response[:response].code.to_i) && response[:response].body.present?

      identity_providers_library = JSON.parse(response[:response].body)
      matching_provider = identity_providers_library.find { |identity_provider| identity_provider['connectionName'] == ENV.fetch('PPG_AUTH_TYPE', nil) }

      return matching_provider if matching_provider.present? && matching_provider['id'].present?
      nil
    end


    def update_existing_user_roles(user, new_role_ids, identity_provider)
      response = send_request_to_ppg("/user-profile?user-id=#{user['email']}")

      return 500 unless response.present? && response[:response].present? && response[:response].code.present?
      return response[:response].code.to_i unless (200..201).include?(response[:response].code.to_i) && response[:response].body.present?

      user_data = JSON.parse(response[:response].body)

      # Extract Role IDs from rolePermissionInfo and only Unique Group IDs from userGroups, in the user_data response payload.
      exising_role_ids = user_data.dig('detail', 'rolePermissionInfo')&.map { |role| role['roleId'] } || []
      group_ids = user_data.dig('detail', 'userGroups')&.map { |group| group['groupId'] }&.uniq || []

      return 500 unless exising_role_ids.present? && group_ids.present?

      response_put = send_request_to_ppg("/user-profile?user-id=#{user['email']}", { role_ids: (exising_role_ids + new_role_ids), group_ids: group_ids, identity_provider: identity_provider, user_data: user_data })

      return response_put[:response].code.to_i if response_put.present? && response_put[:response].present? && response_put[:response].code.present?
      500
    end


    def add_user_contact(user)
      response = send_request_to_ppg("/contact-service/user/contacts?user-id=#{user['email']}", user)

      return response[:response].code.to_i if response.present? && response[:response].present? && response[:response].code.present?
      500
    end


    def send_request_to_ppg(endpoint, data = nil)
      return {  request: nil, response: Struct.new(:code).new(400), status_description: 'No Organisation Administrator was found for this Organisation. User Not Created in PPG.'  } if @admin_check == 0
      return {  request: nil, response: Struct.new(:code).new(424), status_description: 'Unsuccessful Response from CII. User Not Created in PPG.'  } if @cii_body.blank? || JSON.parse(@cii_body)['organisationId'].blank?
      return {  request: nil, response: Struct.new(:code).new(424), status_description: 'Unsuccessful Response from PPG Organisation Creation. User Not Created in PPG.'  } unless (200..201).include?(@ppg_status_code) || @ppg_status_code == 409

      uri = URI.parse(ENV.fetch('PPG_DOMAIN', nil) + endpoint)
      http = Net::HTTP.new(uri.host, uri.port)
      http.use_ssl = true # Set to false, if using HTTP (or locally hosting).

      case endpoint
      when ->(e) { e.start_with?('/organisation-profile/') }
        request = Net::HTTP::Get.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_ORG_PROFILE', nil)
      when ->(e) { e.start_with?('/user-profile?user-id') && data.present? }
        request = Net::HTTP::Put.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_USER_PROFILE', nil)
        request["Content-Type"] = "application/json"
        request.body = build_user_role_put_body(data)
      when ->(e) { e.start_with?('/user-profile?user-id') }
        request = Net::HTTP::Get.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_USER_PROFILE', nil)
      when '/user-profile'
        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_USER_PROFILE', nil)
        request["Content-Type"] = "application/json"
        request.body = build_user_post_body(data)
      when ->(e) { e.start_with?('/contact-service/user/contacts?user-id') }
        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_CONTACT_SERVICE', nil)
        request["Content-Type"] = "application/json"
        request.body = build_user_contact_post_body(data)
      end

      return {  request: request, response: Struct.new(:code).new(500), status_description: 'Internal Error.'  } if data.present? && request.body.nil?

      begin
        response = http.request(request)
        return {  request: request, response: response, status_description: 'Unsuccessful Response from PPG. User Not Created in PPG.'  } # This 'status_description' is provided by default, and is hidden in responses, unless needed to be displayed in a negative scenario.

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, status_description: err  }
      end

      {  request: nil, response: nil, status_description: 'Internal Error.'  } # Fallback, to prevent 500 errors.
    end


    def build_user_post_body(data)
      return nil if data.blank? || data[:user].blank?

      cii_org_data = JSON.parse(@cii_body)

      return {
        "userName": data[:user]['email'],
        "organisationId": cii_org_data['organisationId'],
        "firstName": data[:user]['firstName'],
        "lastName": data[:user]['lastName'],
        "sendUserRegistrationEmail": true,
        "detail": {
          "identityProviderIds": [ data[:identity_provider]['id'] ],
          "roleIds": data[:user_roles]
        }
      }.to_json
    end


    def build_user_role_put_body(data)
      return nil if data.blank? || data[:user_data].blank? || data[:role_ids].blank? || data[:group_ids].blank? || data[:identity_provider].blank?

      return {
        organisationId: data[:user_data]['organisationId'],
        userName: data[:user_data]['userName'],
        firstName: data[:user_data]['firstName'],
        lastName: data[:user_data]['lastName'],
        title: data[:user_data]['title'],
        mfaEnabled: data[:user_data]['mfaEnabled'],
        mfaOpted: data[:user_data]['mfaOpted'],
        password: data[:user_data]['password'],
        accountVerified: data[:user_data]['accountVerified'],
        sendUserRegistrationEmail: data[:user_data]['sendUserRegistrationEmail'],
        originOrganisationName: data[:user_data]['originOrganisationName'],
        companyHouseId: data[:user_data]['companyHouseId'],
        isAdminUser: data[:user_data]['isAdminUser'],
        organisationMfaRequired: data[:user_data]['organisationMfaRequired'],
        isDormant: data[:user_data]['isDormant'],
        detail: {
          identityProviderIds: [ data[:identity_provider]['id'] ],
          roleIds: data[:role_ids],
          groupIds: data[:group_ids]
        }
      }.to_json
    end


    def build_user_contact_post_body(data)
      return nil if data.blank? || data['email'].blank?

      user_contacts = []
      no_data_count = 0

      if data['contactEmail'].present?
        user_contacts << {  contactType: "EMAIL", contactValue: data['contactEmail']  }
      else
        user_contacts << {  contactType: "EMAIL", contactValue: ""  }
        no_data_count+= 1
      end

      if data['contactPhone'].present?
        user_contacts << {  contactType: "PHONE", contactValue: data['contactPhone']  }
      else
        user_contacts << {  contactType: "PHONE", contactValue: ""  }
        no_data_count+= 1
      end

      if data['contactMobile'].present?
        user_contacts << {  contactType: "MOBILE", contactValue: data['contactMobile']  }
      else
        user_contacts << {  contactType: "MOBILE", contactValue: ""  }
        no_data_count+= 1
      end

      if data['contactFax'].present?
        user_contacts << {  contactType: "FAX", contactValue: data['contactFax']  }
      else
        user_contacts << {  contactType: "FAX", contactValue: ""  }
        no_data_count+= 1
      end

      if data['contactSocial'].present?
        user_contacts << {  contactType: "WEB_ADDRESS", contactValue: data['contactSocial']  }
      else
        user_contacts << {  contactType: "WEB_ADDRESS", contactValue: ""  }
        no_data_count+= 1
      end

      return nil if no_data_count >= 5

      return {
        contactPointReason: "GENERAL",
        contactPointName: "User Contact",
        contacts: user_contacts
      }.to_json
    end
  end
end
