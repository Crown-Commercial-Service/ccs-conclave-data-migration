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

        if response.present?
          begin
            response_body = JSON.parse(response.body)

            if response.code.present? && response.code.to_i == 201 && response_body.present? && response_body.is_a?(Hash)
              @ciiResponseList["#{org["scheme-id"]}-#{org["identifier-id"]}"] = response_body
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 201, data: response_body  } # Organisation Migrated to CII.
            elsif response.code.present? && response.code.to_i == 409 && response_body.present? && response_body.is_a?(Hash)
              @ciiResponseList["#{org["scheme-id"]}-#{org["identifier-id"]}"] = response_body
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 409, data: response_body  } # Organisation Already Migrated to CII.
            elsif response.code.present? && response.code.to_i == 404 && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, data: response_body, status_error: 'Not Found Response from CII.', response: response  } # Organisation Not Migrated to CII.
            elsif response.code.present? && response.code.to_i == 401 && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, data: response_body, status_error: 'Unauthorized Response from CII.', response: response  } # Organisation Not Migrated to CII.
            elsif response.code.present? && response.code.to_i == 400 && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, data: response_body, status_error: 'Bad Request Response from CII.', response: response  } # Organisation Not Migrated to CII.
            elsif response.code.present? && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response.code.to_i, data: response_body, status_error: 'Unknown Error from CII.', response: response  } # Organisation Not Migrated to CII.
            else
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: response.body, status_error: 'Internal Error.', response: response  } # Organisation Not Migrated to CII.
            end
          rescue JSON::ParserError => err
            log_error(err)
            if response.code.present? && response.code.to_i == 400 && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, data: response.body, status_error: 'Bad Request Response from CII.', response: response  } # Organisation Not Migrated to CII.
            elsif response.code.present? && response.code.to_i == 401 && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, data: response.body, status_error: 'Unauthorized Response from CII.', response: response  } # Organisation Not Migrated to CII.
            elsif response.code.present? && response.code.to_i == 404 && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, data: response.body, status_error: 'Not Found Response from CII.', response: response  } # Organisation Not Migrated to CII.
            elsif response.code.present? && response.code.to_i == 409 && response.body.present?
              @ciiResponseList["#{org["scheme-id"]}-#{org["identifier-id"]}"] = response.body
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 409, data: response.body  } # Organisation Already Migrated to CII.
            elsif response.code.present? && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response.code.to_i, data: response.body, status_error: 'Unknown Error from CII.', response: response  } # Organisation Not Migrated to CII.
            else
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: response.body, status_error: err.message, response: response  } # Organisation Not Migrated to CII.
            end
          end
        else
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: nil, status_error: 'Empty or No Response from CII.  (DEVELOPER NOTE: Either a 500 internal error, a url 404 from the external call, or just no response at all recieved.)', response: nil  } # Organisation Not Migrated to CII.
        end
      end

      return {  responses: @ciiResponseList, report: { cii_orgs_success_list: @orgSuccessList, cii_orgs_error_List: @orgErrorsList }  }
    end


    def post_data_to_cii(organisation_id_type, organisation_id)
      uri = build_uri("#{ENV.fetch('CII_DOMAIN', nil)}/identities/organisations/schemes/#{organisation_id_type}/identifiers/#{organisation_id}")
      http = build_http(uri)
      request = build_request(uri)

      begin
        response = http.request(request)
        return response

      rescue StandardError => err
        log_error(err)
        @orgErrorsList << {  organisation: "#{organisation_id_type}-#{organisation_id}", successful: false, status: 500, data: request, status_error: err.message, response: response  } # Organisation Not Migrated to CII.
        return nil
      end
    end


    def build_uri(url)
      URI.parse(url.to_s)
    end


    def build_http(uri)
      http = Net::HTTP.new(uri.host, uri.port)
      if ENV.fetch('REMOTE_APP', nil) == 'true'
        http.use_ssl = true
      else
        http.use_ssl = false
      end

      http
    end


    def build_request(uri)
      request = Net::HTTP::Post.new(uri.request_uri)
      request["x-api-key"] = ENV.fetch('CII_API_KEY', nil)
      request
    end


    def log_error(err)
      puts "Error: #{err.message}"
      puts err.backtrace.join("\n")
    end
  end
end
