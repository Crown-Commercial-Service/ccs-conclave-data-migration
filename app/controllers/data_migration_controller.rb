require 'csv'
require 'uri'
require 'net/http'

class DataMigrationController < ApplicationController
    include Authorize::Token
    before_action :validate_api_key

    def validate_as_csv
        # Check a file was uploaded.
        file = params[:file]
        return render json: {  error: "Bad Request", description: "No file csv file found in the request."  }, status: :bad_request if file.nil?

        csv_data = CSV.parse(file.read, headers: true)
        return process_csv_data(csv_data) if csv_data

        return render json: {  error: "Unprocessable Entity", description: "No file csv file found in the request."  }, status: :unprocessable_entity
    end


    def validate_as_json
        # Check content type is correct.
        return render json: {  error: "Bad Request", description: "Incorrect Content-Type. Content and body must be JSON."  }, status: :bad_request unless request.content_type == 'application/json'

        json_data = request.body.read
        return process_json_data(json_data) if json_data

        return render json: {  error: "Unprocessable Entity", description: "Error with JSON request body."  }, status: :unprocessable_entity
    end


    private


    # Read, validate and process the CSV data, to be converted to JSON.
    def process_csv_data(csv_data)
        line_number = 0
        validator = Validate::CsvValidator.new(csv_data)

        if validator.validate
            data = []
            unique_org_id_list = []

            csv_data.each do |row|
                line_number += 1

                next if line_number == 1
                next add_users_to_existing_org(unique_org_id_list, row, data) if unique_org_id_list.include?(row["IdentifierId"])

                unique_org_id_list << row["IdentifierId"]
                data << {
                    "identifier-id" => row["IdentifierId"],
                    "scheme-id" => row["SchemeId"],
                    "rightToBuy"=> right_to_buy_logic(row["OrganisationType"]),
                    "domainName" => row["DomainName"],
                    "orgRoles" => parse_comma_separated_list(row["OrganisationRoles"]),
                    "user" => [{
                        "email" => row["EmailAddress"],
                        "title" => row["Title"],
                        "firstName" => row["FirstName"],
                        "lastName" => row["LastName"],
                        "contactEmail" => row["ContactEmail"],
                        "contactMobile" => row["ContactMobile"],
                        "contactPhone" => row["ContactPhone"],
                        "contactFax" => row["ContactFax"],
                        "contactSocial" => row["ContactSocial"],
                        "userRoles" => parse_comma_separated_list(row["UserRoles"])
                    }]
                }
            end

            return process_json_data(data) if data

            return render json: {  error: "Internal Server Error", description: "Something went wrong and no data was found processed."  }, status: :internal_server_error
        else
            return render json: {  error: validator.errors  }, status: :unprocessable_entity
        end
    end


    # If the organization already exists, instead add data row as a new user to the 'user' array for the org.
    def add_users_to_existing_org(unique_org_id_list, row, data)
        existing_org_index = data.find_index { |org| org["identifier-id"] == row["IdentifierId"] }

        if existing_org_index
          data[existing_org_index]["user"] << {
            "email" => row["EmailAddress"],
            "title" => row["Title"],
            "firstName" => row["FirstName"],
            "lastName" => row["LastName"],
            "contactEmail" => row["ContactEmail"],
            "contactMobile" => row["ContactMobile"],
            "contactPhone" => row["ContactPhone"],
            "contactFax" => row["ContactFax"],
            "contactSocial" => row["ContactSocial"],
            "userRoles" => parse_comma_separated_list(row["UserRoles"])
          }
        end

        return data
    end


    # Right to Buy conversion logic.
    def right_to_buy_logic(org_type)
        case org_type.to_i
        when 0
          return "false"
        when 1..2
          return "false"
        else
          raise "OrganisationType Error: Please enter 0, 1 or 2."
        end
    end


    def parse_comma_separated_list(data_list)
        data_list.split(',').map { |item| { "name" => item.strip } }
    end


    # Check, validate and process the JSON data, to be migrated.
    def process_json_data(json_data)
        validator = Validate::JsonValidator.new

        if validator.validate(json_data)
            data_migration_service = Migrate::DataMigration.new(json_data)
            dm_migrate_orgs_report = data_migration_service.migrate_orgs # {  dmOrgSuccessList: @orgSuccessList, dmOrgErrorsList: @orgErrorsList  }
            dm_migrate_users_report = data_migration_service.migrate_users # {  dmUserSuccessList: @userSuccessList, dmUserErrorsList: @userErrorsList  }

            cii_migration_service = Migrate::Cii.new(json_data)
            cii_migrate_orgs_report = cii_migration_service.migrate_orgs # {  ciiOrgSuccessList: @orgSuccessList, ciiOrgErrorsList: @orgErrorsList  }


            return render json: {  dm_migration_report: { dm_orgs: dm_migrate_orgs_report, dm_users: dm_migrate_users_report }, cii_migration_report: { cii_orgs: cii_migrate_orgs_report }  }, status: :ok
            # return render json: json_data, status: :ok
        else
            return render json: {  error: validator.errors  }, status: :unprocessable_entity
        end
    end
end
