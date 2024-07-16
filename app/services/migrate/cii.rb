require 'net/http'
require 'uri'

module Migrate
  class Cii
    attr_reader :org_success_list, :org_error_list

    def initialize()
      @org_success_list = []
      @org_error_list = []
    end


    def migrate_org(org, org_admin_status)
      @admin_check = org_admin_status

      migrate_org_to_cii(org)
    end


    private


    def migrate_org_to_cii(org)
      response = send_request_to_cii("/identities/organisations/schemes/#{org['scheme-id']}/identifiers/#{org['identifier-id']}")

      if response.present? && response[:response].present? && response[:response].code.present?
        if [200, 201, 409].include?(response[:response].code.to_i) && response[:response].body.present?
          if @admin_check == 0 && (200..201).include?(response[:response].code.to_i)
            delete_response = send_request_to_cii("/identities/organisations/#{JSON.parse(response[:response].body)['organisationId']}")
            @org_error_list << {  organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: 400, status_description: "New Organisation with No Organisation Administrator. Organisation ID #{JSON.parse(response[:response].body)['organisationId']} will be Deleted from CII, and Not Progressed. (Deleted Status: #{delete_response[:response].code.to_i})"  } # Organisation Not Migrated.
            return {  response_status_code: 400, response_body: nil  }
          else
            @org_success_list << {  organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: true, status: response[:response].code.to_i, cii_org_id: JSON.parse(response[:response].body)['organisationId']  } # Organisation Migrated or Already Exists.
            return {  response_status_code: response[:response].code.to_i, response_body: response[:response].body  }
          end
        else
          @org_error_list << {  organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: response[:response].code.to_i, status_description: response[:status_description]  } # Organisation Not Migrated.
          return {  response_status_code: response[:response].code.to_i, response_body: nil  }
        end
      else
        @org_error_list << {  organisation: "#{org['scheme-id']}-#{org['identifier-id']}", successful: false, status: 500, status_description: response[:status_description]  } # Organisation Not Migrated.
        return {  response_status_code: 500, response_body: nil  }
      end
    end


    def send_request_to_cii(endpoint)
      uri = URI.parse(ENV.fetch('CII_DOMAIN', nil) + endpoint)
      http = Net::HTTP.new(uri.host, uri.port)
      http.use_ssl = true # Set to false, if using HTTP (or locally hosting).

      case endpoint
      when ->(e) { e.start_with?('/identities/organisations/schemes/') }
        request = Net::HTTP::Post.new(uri.request_uri)
        request['x-api-key'] = ENV.fetch('CII_API_KEY', nil)
      when ->(e) { e.start_with?('/identities/organisations/') }
        request = Net::HTTP::Delete.new(uri.request_uri)
        request['x-api-key'] = ENV.fetch('CII_DELETE_KEY', nil)
      end

      begin
        response = http.request(request)
        return {  request: request, response: response, status_description: 'Unsuccessful Response from CII. Organisation Not Created in CII.'  } # This 'status_description' is hidden in responses, unless needed to be displayed in a negative scenario.

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, status_description: err  }
      end

      {  request: nil, response: Struct.new(:code).new(418), status_description: nil  } # Fallback, to prevent 500 errors.
    end
  end
end
