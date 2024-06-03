require 'net/http'
require 'uri'

module Migrate
  class Cii
    def initialize(json_data)
      @api_key = ENV.fetch('CII_API_KEY', nil)
      @data = json_data
      @orgErrorsList = []
      @orgSuccessList = []
      @response_status = nil
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
              @response_status = 201
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: true, status: @response_status, data: response_body  } # Organisation Migrated to CII.
            elsif response.code.present? && response.code.to_i == 409 && response_body.present? && response_body.is_a?(Hash)
              @response_status = 409
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: true, status: @response_status, data: response_body  } # Organisation Already Migrated to CII.
            else
              @response_status = response.code.to_i
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: false, status: @response_status, error: nil, data: response.body, response: response  } # Organisation Not Migrated to CII.
            end
          rescue JSON::ParserError => err
            log_error(err)
            @response_status = 500
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: false, status: @response_status, error: err.message, data: response.body, response: nil  } # Organisation Not Migrated to CII.
          end
        else
          @response_status = 500
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: false, status: @response_status, error: 'Empty or no response received from CII.', data: nil, response: nil  } # Organisation Not Migrated to CII.
        end
      end

      return {  ciiOrgSuccessList: @orgSuccessList, ciiOrgErrorsList: @orgErrorsList  }
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
        @orgErrorsList << {  organisation: "#{organisation_id_type}-#{organisation_id}", success: false, status: 500, error: err.message, data: request, response: response  } # Organisation Not Migrated to CII.
        return nil
      end
    end


    def build_uri(url)
      URI.parse(url)
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
      request["x-api-key"] = @api_key
      request
    end


    def log_error(err)
      puts "Error: #{err.message}"
      puts err.backtrace.join("\n")
    end
  end
end
