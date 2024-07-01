require 'net/http'
require 'uri'

module Migrate
  class PpgUsers
    attr_reader :user_success_list, :user_error_list

    def initialize()
      @user_success_list = []
      @user_error_list = []
    end


    def migrate_users(org, ppg_org_response_status_code)
      @ppg_status_code = ppg_org_response_status_code

      migrate_users_to_ppg(org)
    end


    private


    def migrate_users_to_ppg(org)
      org['user'].each do |user|
        response = send_request_to_ppg('/user-profile', user)

        if response.present? && response[:response].present? && response[:response].code.present?
          if [200, 201, 409].include?(response[:response].code.to_i)
            user_contact_response = 409
            user_contact_response = add_user_contact(user) if response[:response].code.to_i != 409
            user_role_response = add_user_roles(user)
            @user_success_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: true, status: response[:response].code.to_i, user_contact_status: user_contact_response, user_roles_status: user_role_response  } # User Migrated or Already Exists.
            return {  response_status_code: response[:response].code.to_i, response_body: nil  }
          else
            @user_error_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: response[:response].code.to_i, status_description: response[:status_description]  } # User Not Migrated.
            return {  response_status_code: response[:response].code.to_i, response_body: nil  }
          end
        else
          @user_error_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: 500, status_description: response[:status_description]  } # User Not Migrated.
          return {  response_status_code: 500, response_body: nil  }
        end
      end
    end


    def send_request_to_ppg(endpoint, data = nil)
      return {  request: nil, response: Struct.new(:code).new(400), status_description: 'No Organisation Administrator found for this Organisation. Organisation Not Created in PPG'  } if @admin_check == 0
      return {  request: nil, response: Struct.new(:code).new(403), status_description: 'Unsuccessful Response from CII. Organisation Not Created in PPG'  } unless (200..201).include?(@cii_status_code) || @cii_status_code == 409

      uri = URI.parse(ENV.fetch('PPG_DOMAIN', nil) + endpoint)
      http = Net::HTTP.new(uri.host, uri.port)
      http.use_ssl = true # Set to false, if using HTTP (or locally hosting).

      case endpoint
      when '/user-profile/'
        return {  request: nil, response: Struct.new(:code).new(409), status_description: 'Organisation Already Exists in CII. Duplicate Organisation Not Created in PPG'  } if @cii_status_code == 409

        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_USER_PROFILE', nil)
        request["Content-Type"] = "application/json"
        request.body = build_user_post_body(data)
      end

      return {  request: request, response: Struct.new(:code).new(500), status_description: 'Internal Error.'  } if data.present? && request.body.nil?

      begin
        response = http.request(request)
        return {  request: request, response: response, status_description: 'Unsuccessful Response from PPG. Organisation Not Created in PPG.'  } # This 'status_description' is provided by default, and is hidden in responses, unless needed to be displayed in a negative scenario.

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, status_description: err  }
      end

      {  request: nil, response: nil, status_description: 'Internal Error.'  } # Fallback, to prevent 500 errors.
    end


    def build_user_post_body(data)
      return nil if data.blank? || @cii_body.blank? || JSON.parse(@cii_body)['organisationId'].blank?

      cii_org_data = JSON.parse(@cii_body)

      return {
        "userName": data['email'],
        "organisationId": cii_org_data['organisationId'],
        "firstName": data['email'],
        "lastName": data['email'],
        "mfaEnabled": false,#????????????????????????????????????????????????????????????????????????????????????????????????? Similar to line below; will this prevent a user being deleted, if true?
        "isAdminUser": false,#????????????????????????????????????????????????????????????????????????????????????????????????? This instead of additional call to PPG Put endpoint?
        "sendUserRegistrationEmail": true,
        "detail": {
          "identityProviderIds": [ 123, 456 ],
          "roleIds": [ 119178, 119171 ]
        }
      }.to_json
    end
  end
end
