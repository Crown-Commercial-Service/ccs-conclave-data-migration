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
                    "organisationType" => row["OrganisationType"],
                    "domainName" => row["DomainName"],
                    "orgRoles" => Common::Helper.parse_comma_separated_list(row["OrganisationRoles"]),
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
                        "userRoles" => Common::Helper.parse_comma_separated_list(row["UserRoles"])
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
            "userRoles" => Common::Helper.parse_comma_separated_list(row["UserRoles"])
          }
        end

        return data
    end


    # Check, validate and process the JSON data, to be migrated.
    def process_json_data(json_data)
        validator = Validate::JsonValidator.new

        if validator.validate(json_data)
            json_data = json_data.is_a?(String) ? JSON.parse(json_data) : json_data

            data_migration_service = Migrate::DataMigration.new(json_data)
            dm_migrate_orgs = data_migration_service.migrate_orgs # { responses: nil, report: { dm_orgs_success_list: @orgSuccessList, dm_orgs_error_list: @orgErrorsList } }
            dm_migrate_orgs_report = dm_migrate_orgs[:report] # { dm_orgs_success_list: @orgSuccessList, dm_orgs_error_list: @orgErrorsList }
            dm_migrate_users = data_migration_service.migrate_users # { responses: nil, report: { dm_users_success_list: @userSuccessList, dm_users_error_list: @userErrorsList } }
            dm_migrate_users_report = dm_migrate_users[:report] # { dm_users_success_list: @userSuccessList, dm_users_error_list: @userErrorsList }

            cii_migration_service = Migrate::Cii.new(json_data)
            cii_migrate_orgs = cii_migration_service.migrate_orgs # { responses: @ciiResposeList, report: { cii_orgs_success_list: @orgSuccessList, cii_orgs_error_List: @orgErrorsList } }
            cii_migrate_orgs_report = cii_migrate_orgs[:report] # { cii_orgs_success_list: @orgSuccessList, cii_orgs_error_List: @orgErrorsList }
            #cii_response_list = cii_migrate_orgs[:responses]

            #ppg_migration_service = Migrate::Ppg.new(json_data, cii_response_list)
            #ppg_migrate_orgs = ppg_migration_service.migrate_orgs # { responses: nil, report: { ppg_orgs_success_list: @orgSuccessList, ppg_orgs_error_list: @orgErrorsList } }
            #ppg_migrate_orgs_report = ppg_migrate_orgs[:report] # { ppg_orgs_success_list: @orgSuccessList, ppg_orgs_error_list: @orgErrorsList }
            #ppg_migrate_users = ppg_migration_service.migrate_users # { responses: nil, report: { ppg_users_success_list: @orgSuccessList, ppg_users_error_list: @orgErrorsList } }
            #ppg_migrate_users_report = ppg_migrate_users[:report] # { ppg_users_success_list: @orgSuccessList, ppg_users_error_list: @orgErrorsList }

            return render json: {
                dm_migration_report: {
                    dm_orgs: dm_migrate_orgs_report,
                    dm_users: dm_migrate_users_report
                },
                cii_migration_report: {
                    cii_orgs: cii_migrate_orgs_report
                }#,
                #ppg_migration_report: {
                    #ppg_orgs: ppg_migrate_orgs_report,
                    #ppg_users: ppg_migrate_users_report
                #}
            }, status: :ok
        else
            return render json: {  error: validator.errors  }, status: :unprocessable_entity
        end
    end
end
