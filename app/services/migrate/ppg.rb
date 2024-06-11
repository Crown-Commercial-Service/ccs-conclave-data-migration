require 'net/http'
require 'uri'

# This is where the data will be added to external PPG.
module Migrate
  class Ppg
    def initialize(json_data)
      @data = json_data
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
        response = post_data_to_ppg('/organisation-profile', org)

        if response.present?
          begin
            response_body = JSON.parse(response.body)

            if response.code.present? && response.code.to_i == 201 && response_body.present? && response_body.is_a?(Hash)
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 201, data: response_body  } # Organisation Migrated to PPG.
            elsif response.code.present? && response.code.to_i == 409 && response_body.present? && response_body.is_a?(Hash)
              next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 409, data: response_body  } # Organisation Already Migrated to PPG.
            elsif response.code.present? && response.code.to_i == 404 && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, data: response_body, status_error: 'Not Found Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
            elsif response.code.present? && response.code.to_i == 401 && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, data: response_body, status_error: 'Unauthorized Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
            elsif response.code.present? && response.code.to_i == 400 && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, data: response_body, status_error: 'Bad Request Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
            elsif response.code.present? && response_body.present? && response_body.is_a?(Hash)
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response.code.to_i, data: response_body, status_error: 'Unknown Error from PPG.', response: response  } # Organisation Not Migrated to PPG.
            else
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: response.body, status_error: 'Internal Error.', response: response  } # Organisation Not Migrated to PPG.
            end
          rescue JSON::ParserError => err
            log_error(err)

            if response.code.present? && response.code.to_i == 400 && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 400, data: response.body, status_error: 'Bad Request Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
            elsif response.code.present? && response.code.to_i == 401 && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 401, data: response.body, status_error: 'Unauthorized Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
            elsif response.code.present? && response.code.to_i == 404 && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 404, data: response.body, status_error: 'Not Found Response from PPG.', response: response  } # Organisation Not Migrated to PPG.
            elsif response.code.present? && response.body.present?
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response.code.to_i, data: response.body, status_error: 'Unknown Error from PPG.', response: response  } # Organisation Not Migrated to PPG.
            else
              next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: response.body, status_error: err.message, response: response  } # Organisation Not Migrated to PPG.
            end
          end
        else
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: nil, status_error: 'Empty or No Response from PPG.  (DEVELOPER NOTE: Either a 500 internal error, a 404 from the external call, or just no response at all recieved.)', response: nil  } # Organisation Not Migrated to PPG.
        end
      end

      return {  ppgOrgSuccessList: @orgSuccessList, ppgOrgErrorsList: @orgErrorsList  }
    end

    def post_data_to_ppg(endpoint, data)
      uri = build_uri(ENV.fetch('PPG_DOMAIN', nil) + endpoint)
      http = build_http(uri)
      request = build_request(uri, data)

      begin
        response = http.request(request)
        return response

      rescue StandardError => err
        log_error(err)

        @orgErrorsList << {  organisation: "#{organisation_id_type}-#{organisation_id}", successful: false, status: 500, data: request, status_error: err.message, response: response  } # Organisation Not Migrated to PPG.
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

    def build_request(uri, data)
      request = Net::HTTP::Post.new(uri.request_uri)
      request["x-api-key"] = ENV.fetch('PPG_API_KEY', nil)
      request.body = build_body(data.to_json)
      request["Content-Type"] = "application/json"
      request
    end

    def build_body(data)
      # Need CII Data to fill to be this data. So call an endpoint of CII and directly deposit response as body for this PPG request?
      {
        "identifier": {
          "id": data["identifier-id"],
          "legalName": "<CII Data>",
          "uri": "",
          "scheme": data["scheme-id"]
        },
        "additionalIdentifiers": [],
        "address": {
          "streetAddress": "Grenville Court, Britwell Road, Burnham",
          "locality": "Buckinghamshire",
          "region": "",
          "postalCode": "SL1 8DF",
          "countryCode": "GB",
          "countryName": null
        },
        "detail": {
          "organisationId": "441761659268971733",
          "creationDate": "10/01/2022",
          "businessType": "",
          "supplierBuyerType": 0,
          "isSme": false,
          "isVcse": false,
          "rightToBuy": false,
          "isActive": true
        }
      }
    end

    def log_error(err)
      puts "Error: #{err.message}"
      puts err.backtrace.join("\n")
    end
  end
end
