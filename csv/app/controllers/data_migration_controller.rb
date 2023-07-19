require 'csv'
require 'uri'
require 'net/http'

class DataMigrationController < ApplicationController
    def migrate
        # Authorization.
        @api_key = request.headers["x-api-key"].to_s
        if @api_key != ENV['DMJSONKEY']
            render json: { error: "Unauthorized" }, status: :unauthorized
            return
        end
    
        # Check a file was uploaded.
        file = params[:file]
        if file.nil?
            render json: { error: "No file uploaded" }, status: :unprocessable_entity
            return
        end

        # Read and validate the CSV data.
        line_number = 0
        csv_data = CSV.parse(file.read, headers: true)
        validator = CsvValidator.new(csv_data)

        # If validation passes, gather all the data from the CSV to send to DM app.
        if validator.validate
            data ||= []

            csv_data.each do |row|
                line_number += 1

                next if line_number == 1

                data << {
                    "identifier-id": row["IdentifierId"],
                    "scheme-id": row["SchemeId"],
                    rightToBuy: right_to_buy_logic(row["OrganisationType"]),
                    domainName: row["DomainName"],
                    orgRoles: parse_comma_separated_list(row["OrganisationRoles"]),
                    user: [{
                        email: row["EmailAddress"],
                        title: row["Title"],
                        firstName: row["FirstName"],
                        lastName: row["LastName"],
                        contactPointName: row["ContactName"],
                        contactEmail: row["ContactEmail"],
                        contactMobile: row["ContactMobile"],
                        contactPhone: row["ContactPhone"],
                        contactFax: row["ContactFax"],
                        contactSocial: row["ContactSocial"],
                        userRoles: parse_comma_separated_list(row["UserRoles"])
                    }]
                }
                
                #puts "payload_here--> #{data}"

            end

            # Finally, send data to DM aplication, to be processed.
            send_to_data_migration(data)
            #render json: { CSV_Payload_Sent_To_Data_Migration: data, Response_From_DM: response.body }, status: :ok

        else
            render json: { error: validator.errors }, status: :unprocessable_entity
        end
    end

    def right_to_buy_logic(org_type)
        case org_type.to_i
        when 0
            return "false"
        when 1..2
            return "false"
        else
            return "OrganisationType Error: Please enter 0, 1 or 2."
        end        
    end

    private

    def parse_comma_separated_list(data_list)
        data = []
        data_list.split(',').map do |item|
            data << { name: item.strip }
        end
        return data
    end

    def send_to_data_migration(data)
        uri = URI.parse(ENV['DMJSONURL'])
        http = Net::HTTP.new(uri.host, uri.port)
        http.use_ssl = true
      
        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = @api_key
        request.body = data.to_json
        request["Content-Type"] = "application/json"
      
        begin
          response = http.request(request)
        rescue Timeout::Error, Errno::EINVAL, Errno::ECONNRESET, Errno::ECONNREFUSED, EOFError, Net::HTTPBadResponse, Net::HTTPHeaderSyntaxError, Net::ProtocolError => e
          render json: { error: e.message }, status: :unprocessable_entity
          return

        end
      
        render json: { CSV_Payload_Sent_To_Data_Migration: data, Response_From_DM: response.body }, status: :ok
    end
      
end
