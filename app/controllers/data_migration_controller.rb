require 'csv'
require 'uri'
require 'net/http'


# Controller for both the JSON and CSV endpoints. Validates and process both sets of data, when either is provided in a request.
class DataMigrationController < ApplicationController
    include Authorize::Token
    before_action :validate_api_key


    # CSV request endpoint entry point.
    def validate_as_csv
        # Check a file was uploaded.
        file = params[:file]
        return render json: {  error: 'Bad Request', description: 'No file csv file found in the request.'  }, status: :bad_request if file.nil?

        csv_data = CSV.parse(file.read, headers: true)
        return process_csv_data(csv_data) if csv_data

        return render json: {  error: 'Unprocessable Entity', description: 'No file csv file found in the request.'  }, status: :unprocessable_entity
    end


    # JSON request endpoint entry point.
    def validate_as_json
        # Check content type is correct.
        return render json: {  error: 'Bad Request', description: 'Incorrect Content-Type. Content and body must be JSON.'  }, status: :bad_request unless request.content_type == 'application/json'

        json_data = request.body.read
        return process_json_data(json_data) if json_data

        return render json: {  error: 'Unprocessable Entity', description: 'Error with JSON request body.'  }, status: :unprocessable_entity
    end


    private


    # Read, validate and process the CSV data, to then be converted into JSON.
    def process_csv_data(csv_data)
        line_number = 0
        validator = Validate::CsvValidator.new(csv_data)

        if validator.validate
            data = []
            unique_org_id_list = []

            csv_data.each do |row|
                line_number += 1

                next if line_number == 1
                next add_users_to_existing_org(row, data) if unique_org_id_list.include?("#{row['SchemeId']}-#{row['IdentifierId']}")

                unique_org_id_list << "#{row['SchemeId']}-#{row['IdentifierId']}"

                data << {
                    "identifier-id" => row["IdentifierId"],
                    "scheme-id" => row["SchemeId"],
                    "organisationType" => row["OrganisationType"].to_s,
                    "domainName" => row["DomainName"],
                    "orgRoles" => Common::Helper.parse_comma_separated_list(row["OrganisationRoles"]),
                    "user" => [{
                        "email" => row["EmailAddress"],
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

            return render json: {  error: 'Internal Server Error', description: 'Internal Error.'  }, status: :internal_server_error
        else
            return render json: {  error: validator.errors  }, status: :unprocessable_entity
        end
    end


    # If an organisation already exists and so is a duplicate, add user(s) to the already existing organisation entry.
    def add_users_to_existing_org(row, data)
        existing_org_index = data.find_index { |org| "#{org['scheme-id']}-#{org['identifier-id']}" == "#{row['SchemeId']}-#{row['IdentifierId']}" }

        if existing_org_index
          data[existing_org_index]['user'] << {
            "email" => row["EmailAddress"],
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


    # Check, validate and process the JSON data, and then migrate.
    def process_json_data(json_data)
        validator = Validate::JsonValidator.new

        if validator.validate(json_data)
            json_data = json_data.is_a?(String) ? JSON.parse(json_data) : json_data

            # Initialise all Migration Services.
            cii_org_migration_service = Migrate::Cii.new()
            ppg_org_migration_service = Migrate::PpgOrganisations.new()
            ppg_user_migration_service = Migrate::PpgUsers.new()
            data_migration_service = Migrate::DataMigration.new()
            administrated_organisations_list = []

            json_data.each do |org|
                # Organisation Check for an Admin User.
                org_admin_status = Common::Helper.org_admin_check(org, administrated_organisations_list)
                administrated_organisations_list << "#{org['scheme-id']}-#{org['identifier-id']}" if org_admin_status == 2

                # Migrate Organisations.
                cii_migration_service_response = cii_org_migration_service.migrate_org(org)
                ppg_migration_service_response_org = ppg_org_migration_service.migrate_org(org, org_admin_status, cii_migration_service_response[:response_status_code], cii_migration_service_response[:response_body])
                data_migration_service.migrate_org(org, cii_migration_service_response[:response_status_code], ppg_migration_service_response_org[:response_status_code])

                # Migrate Users.
                org['user'].each do |user|
                    ppg_migration_service_response_user = ppg_user_migration_service.migrate_user(org, user, org_admin_status, ppg_migration_service_response_org[:response_status_code], cii_migration_service_response[:response_body])
                    data_migration_service.migrate_user(org, user, ppg_migration_service_response_user[:response_status_code])
                end
            end

            # Return a Compiled Report for the Completed Migration, in the response.
            return render json: {
                dm_report: {
                    orgs: data_migration_service.org_list,
                    users: data_migration_service.user_list
                },
                cii_report: {
                    orgs: {
                        success_report: cii_org_migration_service.org_success_list,
                        error_report: cii_org_migration_service.org_error_list
                    }
                },
                ppg_report: {
                    orgs: {
                        success_report: ppg_org_migration_service.org_success_list,
                        error_report: ppg_org_migration_service.org_error_list
                    },
                    users: {
                        success_report: ppg_user_migration_service.user_success_list,
                        error_report: ppg_user_migration_service.user_error_list
                    }
                }
            }, status: :ok
        else
            return render json: {  error: validator.errors  }, status: :bad_request
        end
    end
end
