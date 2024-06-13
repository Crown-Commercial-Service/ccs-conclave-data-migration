require 'net/http'
require 'uri'

module Migrate
  class Ppg
    def initialize(json_data, cii_response_list)
      @data = json_data
      @cii_responses = cii_response_list
      @orgErrorsList = []
      @orgSuccessList = []
      @userErrorsList = []
      @userSuccessList = []
    end


    def migrate_orgs
      migrate_orgs_to_ppg
    end


    def migrate_users
      migrate_users_to_ppg
    end


    private


    def migrate_orgs_to_ppg
      @data.each do |org|
        response = send_request_to_ppg('/organisation-profile', org)

        if response.present? && response[:response]
          if response[:response].code.present? && response[:response].code.to_i == 201 && response[:response].body.present?
            next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 201, data: org  } # Organisation Migrated to PPG.
          elsif ((response[:response].code.present? && response[:response].code.to_i == 409 && response[:response].body.present?) || (response[:response] == 409))
            next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 409, data: org  } # Organisation Already Migrated to PPG.
          elsif response[:response].code.present? && response[:response].code.to_i == 404
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, data: org, status_error: 'Not Found Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
          elsif response[:response].code.present? && response[:response].code.to_i == 401
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, data: org, status_error: 'Unauthorized Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
          elsif response[:response].code.present? && response[:response].code.to_i == 400
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, data: org, status_error: 'Bad Request Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
          elsif response[:response].code.present?
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response[:response].code.to_i, data: org, status_error: 'Unknown Error from PPG.', response: response  } # Organisation Not Migrated to PPG.
          else
            next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: 'Internal Error.', response: response  } # Organisation Not Migrated to PPG.
          end
        elsif response.present? && response['error']
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: response['error'], response: response  } # Organisation Not Migrated to PPG.
        else
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: 'Empty or No Response from PPG. (Either a 500 internal error, a url 404 from the external call, or just no response at all received).', response: nil  } # Organisation Not Migrated to PPG.
        end
      end

      return {  responses: nil, report: { ppg_orgs_success_list: @orgSuccessList, ppg_orgs_error_list: @orgErrorsList }  }
    end


    def send_request_to_ppg(endpoint, data = nil)
      uri = URI.parse(ENV.fetch('PPG_DOMAIN', nil) + endpoint)

      http = Net::HTTP.new(uri.host, uri.port)
      if ENV.fetch('REMOTE_APP', nil) == 'true'
        http.use_ssl = true
      else
        http.use_ssl = false
      end

      if data
        request = Net::HTTP::Post.new(uri.request_uri)
        request.body = build_body(data)
        request["Content-Type"] = "application/json"
      else
        request = Net::HTTP::Get.new(uri.request_uri)
      end

      request["x-api-key"] = ENV.fetch('PPG_API_KEY', nil)

      if data && request.body == nil
        return {  request: request, response: 409, error: "CII returned a 409 Conflict for this organisation #{data["scheme-id"]}-#{data["identifier-id"]}. That means this organisation should already exists in PPG and will not be created."  }
      end

      begin
        response = http.request(request)
        return {  request: request, response: response, error: nil  }

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, error: err  }
      end
    end


    def build_body(data)
      if @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"].present?
        return {
          "identifier": @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"]['identifier'],
          "additionalIdentifiers": @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"]['additionalIdentifier'],
          "address": @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"]['address'],
          "detail": {
            "organisationId": @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"]['organisationId'],
            "supplierBuyerType": data["organisationType"],
            "rightToBuy": Common::Helper.org_type_to_boolean("#{data["organisationType"]}"),
            "isActive": true,
            "domainName": data["domainName"]
          }
        }.to_json
      else
        return nil
      end
    end
  end
end
