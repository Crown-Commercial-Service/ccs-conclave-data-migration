require 'net/http'
require 'uri'

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
      unless @cii_body.blank? || JSON.parse(@cii_body)['organisationId'].blank?
        user_roles = get_user_roles(user)
        identity_provider = get_identity_provider

        if user_roles.present? && identity_provider.present?
          response = send_request_to_ppg('/user-profile', {  user: user, user_roles: user_roles, identity_provider: identity_provider  })

          if response.present? && response[:response].present? && response[:response].code.present?
            if [200, 201, 409].include?(response[:response].code.to_i)
              # user_contact_response = 409
              # user_contact_response = add_user_contact(user) if response[:response].code.to_i != 409
              @user_success_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: true, status: response[:response].code.to_i, user_contact_status: 123  } # User Migrated or Already Exists.
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
      else
        @user_error_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: 403, status_description: 'Unsuccessful Response from CII. Organisation Not Created in PPG.'  } # User Not Migrated.
        return {  response_status_code: 403, response_body: nil  }
      end
    end


    def get_user_roles(user)
      cii_org_data = JSON.parse(@cii_body)
      response = send_request_to_ppg("/organisation-profile/#{cii_org_data['organisationId']}/roles")

      return nil unless response.present? && response[:response].present? && response[:response].code.present? && response[:response].body.present?

      roles_library = JSON.parse(response[:response].body)
      matching_roles = []

      user['userRoles'].each do |role|
        matching_roles.concat(roles_library.select { |role_data| role_data['roleKey'] == role['key'] })
      end

      return matching_roles if matching_roles.present? && matching_roles.any? { |matched_role| matched_role['roleId'].present? }
      nil
    end


    def get_identity_provider
      cii_org_data = JSON.parse(@cii_body)
      response = send_request_to_ppg("/organisation-profile/#{cii_org_data['organisationId']}/identity-providers")

      return nil unless response.present? && response[:response].present? && response[:response].code.present? && response[:response].body.present?

      identity_providers_library = JSON.parse(response[:response].body)
      matching_provider = identity_providers_library.find { |identity_provider| identity_provider['connectionName'] == ENV.fetch('PPG_AUTH_TYPE', nil) }

      return matching_provider if matching_provider.present? && matching_provider['id'].present?
      nil
    end


    def send_request_to_ppg(endpoint, data = nil)
      return {  request: nil, response: Struct.new(:code).new(400), status_description: 'No Organisation Administrator was found for this Organisation. User Not Created in PPG.'  } if @admin_check == 0
      return {  request: nil, response: Struct.new(:code).new(403), status_description: 'Unsuccessful Response from PPG Organisation Creation. User Not Created in PPG.'  } unless (200..201).include?(@ppg_status_code) || @ppg_status_code == 409

      uri = URI.parse(ENV.fetch('PPG_DOMAIN', nil) + endpoint)
      http = Net::HTTP.new(uri.host, uri.port)
      http.use_ssl = true # Set to false, if using HTTP (or locally hosting).

      case endpoint
      when ->(e) { e.start_with?('/organisation-profile/') }
        request = Net::HTTP::Get.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_ORG_PROFILE', nil)
      when '/user-profile'
        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_USER_PROFILE', nil)
        request["Content-Type"] = "application/json"
        request.body = build_user_post_body(data)
      when ->(e) { e.start_with?('/contact-service/user/contacts') }
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


    def build_user_contact_post_body(data)
      return nil if data.blank? || @cii_body.blank? || JSON.parse(@cii_body)['contactPoint'].blank?

      cii_org_data = JSON.parse(@cii_body)
      org_contacts = []

      if cii_org_data['contactPoint']['email'].present?
        org_contacts << {  contactType: "EMAIL", contactValue: cii_org_data['contactPoint']['email']  }
      end

      if cii_org_data['contactPoint']['telephone'].present?
        org_contacts << {  contactType: "PHONE", contactValue: cii_org_data['contactPoint']['telephone']  }
      end

      if cii_org_data['contactPoint']['faxNumber'].present?
        org_contacts << {  contactType: "FAX", contactValue: cii_org_data['contactPoint']['faxNumber']  }
      end

      if cii_org_data['contactPoint']['uri'].present?
        org_contacts << {  contactType: "WEB_ADDRESS", contactValue: cii_org_data['contactPoint']['uri']  }
      end

      return {
        address: cii_org_data['address'],
        contactPointName: "#{cii_org_data['contactPoint']['name']}",
        contacts: org_contacts
      }.to_json
    end
  end
end
