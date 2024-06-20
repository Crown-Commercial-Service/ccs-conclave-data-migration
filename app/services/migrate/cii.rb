require 'net/http'
require 'uri'

module Migrate
  class Cii
    attr_reader :org_success_list, :org_error_list

    def initialize()
      @org_success_list = []
      @org_error_list = []
    end


    def migrate_org(org)
      migrate_org_to_cii(org)
    end


    private


    def migrate_org_to_cii(org)
      response = post_data_to_cii(org["scheme-id"], org["identifier-id"])

      if response.present? && response[:response].present? && response[:response].code.present?
        if (response[:response].code.to_i == 200 || response[:response].code.to_i == 201 || response[:response].code.to_i == 409) && response[:response].body.present?
          @org_success_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: response[:response].code.to_i, cii_org_id: JSON.parse(response[:response].body)['organisationId']  } # Organisation Migrated or Already Exists.
          return {  response_status_code: response[:response].code.to_i, response_body: response[:response].body  }
        else
          @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response[:response].code.to_i, status_description: response[:status_description], response: response  } # Organisation Not Migrated.
          return {  response_status_code: response[:response].code.to_i, response_body: nil  }
        end
      else
        @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, status_description: response[:status_description], response: response  } # Organisation Not Migrated.
        return {  response_status_code: 500, response_body: nil  }
      end
    end


    def post_data_to_cii(organisation_id_type, organisation_id)
      uri = URI.parse(ENV.fetch('CII_DOMAIN', nil) + "/identities/organisations/schemes/#{organisation_id_type}/identifiers/#{organisation_id}")
      http = Net::HTTP.new(uri.host, uri.port)
      http.use_ssl = true # Set to false, if using HTTP (or locally hosting).

      request = Net::HTTP::Post.new(uri.request_uri)
      request["x-api-key"] = ENV.fetch('CII_API_KEY', nil)

      begin
        response = http.request(request)
        return {  request: request, response: response, status_description: 'Unsuccessful Response from CII. Organisation Not Created in CII.'  } # This 'status_description' is hidden in responses, unless needed to be displayed in a negative scenario.

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, status_description: err  }
      end

      {  request: nil, response: nil, status_description: 'Internal Error.'  } # Fallback, to prevent 500 errors.
    end
  end
end
