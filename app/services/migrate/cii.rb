require 'net/http'
require 'uri'

module Migrate
  class Cii
    def initialize(json_data)
      @data = json_data
      @orgErrorsList = []
      @orgSuccessList = []
      @ciiResponseList = {}
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
            @ciiResponseList["#{org["scheme-id"]}-#{org["identifier-id"]}"] = response[:response].body
            next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 201, data: org  } # Organisation Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 409 && response[:response].body.present?
            next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 409, data: org  } # Organisation Already Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 404
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, data: org, status_error: 'Not Found Response from CII.', response: response  } # Organisation Not Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 401
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, data: org, status_error: 'Unauthorized Response from CII.', response: response  } # Organisation Not Migrated to CII.
          elsif response[:response].code.present? && response[:response].code.to_i == 400
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, data: org, status_error: 'Bad Request Response from CII.', response: response  } # Organisation Not Migrated to CII.
          elsif response[:response].code.present?
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response[:response].code.to_i, data: org, status_error: 'Unknown Error from CII.', response: response  } # Organisation Not Migrated to CII.
          else
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: 'Internal Error.', response: response  } # Organisation Not Migrated to CII.
          end
        elsif response.present? && response['error']
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: response['error'], response: response  } # Organisation Not Migrated to CII.
        else
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: 'Empty or No Response from CII. (Either a 500 internal error, a url 404 from the external call, or just no response at all received).', response: nil  } # Organisation Not Migrated to CII.
        end
      end

      return {  responses: @ciiResponseList, report: { cii_orgs_success_list: @orgSuccessList, cii_orgs_error_List: @orgErrorsList }  }
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
