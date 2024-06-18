require 'net/http'
require 'uri'

module Migrate
  class Cii
    def initialize(json_data)
      @data = json_data
      @org_success_list = []
      @org_error_list = []
      @response_list = {}
      @response_status_code_list = {}
    end


    def migrate_orgs
      migrate_orgs_to_cii
    end


    private


    def migrate_orgs_to_cii
      @data.each do |org|
        response = post_data_to_cii(org["scheme-id"], org["identifier-id"])

        if response.present? && response[:response]
          if response[:response].code.present? && response[:response].code.to_i == 201 && response[:response].body.present?
            @response_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = response[:response].body
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 201  }
            next @org_success_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 201, cii_org_id: JSON.parse(response[:response].body)['organisationId']  } # Organisation Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 409 && response[:response].body.present?
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 409  }
            next @org_success_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 409, cii_org_id: JSON.parse(response[:response].body)['organisationId']  } # Organisation Already Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 404
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 404  }
            next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, status_error: 'Not Found Response from CII.', response: response  } # Organisation Not Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 401
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 401  }
            next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, status_error: 'Unauthorized Response from CII.', response: response  } # Organisation Not Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 400
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 400  }
            next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, status_error: 'Bad Request Response from CII.', response: response  } # Organisation Not Migrated to CII.
          elsif response[:response].code.present?
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: response[:response].code.to_i  }
            next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response[:response].code.to_i, status_error: 'Unknown Error from CII.', response: response  } # Organisation Not Migrated to CII.
          else
            @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 500  }
            next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, status_error: 'Internal Error.', response: response  } # Organisation Not Migrated to CII.
          end
        elsif response.present? && response[:error]
          @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 500  }
          next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, status_error: response[:error], response: response  } # Organisation Not Migrated to CII.
        else
          @response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 500  }
          next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, status_error: 'Empty or No Response from CII. (Either a 500 internal error, a url 404 from the external call, or just no response at all received).', response: nil  } # Organisation Not Migrated to CII.
        end
      end

      return {  responses: @response_list, reports: {  success_report: @org_success_list, error_report: @org_error_list  }, statuses: @response_status_code_list  }
    end


    def post_data_to_cii(organisation_id_type, organisation_id)
      uri = URI.parse(ENV.fetch('CII_DOMAIN', nil) + "/identities/organisations/schemes/#{organisation_id_type}/identifiers/#{organisation_id}")

      http = Net::HTTP.new(uri.host, uri.port)
      if ENV.fetch('REMOTE_APP', nil) == 'true'
        http.use_ssl = true
      else
        http.use_ssl = false
      end

      request = Net::HTTP::Post.new(uri.request_uri)
      request["x-api-key"] = ENV.fetch('CII_API_KEY', nil)

      begin
        response = http.request(request)
        return {  request: request, response: response, error: nil  }

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, error: err  }
      end
    end
  end
end
