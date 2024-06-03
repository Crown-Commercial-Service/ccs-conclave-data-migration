require 'net/http'
require 'uri'

# This is where the data will be added to external PPG.
module Migrate
  class Ppg
    def initialize(json_data)
      @api_key = ENV.fetch('PPG_API_KEY', nil)
      @data = json_data
      @orgErrorsList = []
      @orgSuccessList = []
      @userErrorsList = []
      @userSuccessList = []
      @response_status = nil
    end

    def migrate_orgs
      migrate_orgs_to_ppg
    end

    def migrate_users
      migrate_users_to_ppg
    end


    private


    def send_to_data_migration(data)
      uri = build_uri
      http = build_http(uri)
      request = build_request(uri, data)

      begin
        response = http.request(request)
        handle_response(response)
      rescue StandardError => e
        log_error(e)
        render_error_response("Failed to send data for migration. #{e.message}")
      end
    end

    def build_uri
      URI.parse(ENV.fetch('PPG_DOMAIN', nil))
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
      request["x-api-key"] = @api_key
      request.body = data.to_json
      request["Content-Type"] = "application/json"
      request
    end

    def handle_response(response)
      if response
        begin
          response_body = JSON.parse(response.body)

          if response_body.is_a?(Hash) && response_body.empty?
            render_success_response(data, response.code.to_i)
          else
            render_json_response(response_body, response.code.to_i)
          end
        rescue JSON::ParserError => e
          log_error(e)
          render_json_response(response.body, response.code.to_i)
        end
      else
        render_empty_response
      end
    end

    def render_success_response(data, status)
      { csv_data_sent_to_data_migration: data, status: status }
    end

    def render_json_response(response_body, status)
      { response_body: response_body, status: status }
    end

    def render_empty_response
      { status: :no_content, message: 'No content in the response.' }
    end

    def render_error_response(error_message)
      { error: error_message, status: :unprocessable_entity }
    end

    def log_error(err)
      puts "Error: #{err.message}"
      puts err.backtrace.join("\n")
    end
  end
end
