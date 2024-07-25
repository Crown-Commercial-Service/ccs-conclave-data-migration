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

        return render json: {  error: 'Unprocessable Entity', description: 'Error with CSV file data.'  }, status: :unprocessable_entity
    end


    # JSON request endpoint entry point.
    def validate_as_json
        # Check content type is correct.
        return render json: {  error: 'Bad Request', description: 'Incorrect Content-Type. Content and body must be JSON.'  }, status: :bad_request unless request.content_type == 'application/json'

        json_data = request.body.read
        return process_json_data(json_data) if json_data

        return render json: {  error: 'Unprocessable Entity', description: 'Error with JSON request body.'  }, status: :unprocessable_entity
    end


    # Query request endpoint entry point.
    def migration_query
        # Check a query ID was provided.
        return render json: {  error: 'Bad Request', description: 'No Query ID provided in request URL. Please provide a valid query ID.'  }, status: :bad_request unless params[:query_id].present?

        query_id = params[:query_id].to_i

        return process_migration_query(query_id) if query_id.present? && query_id > 0

        render json: {  error: 'Unprocessable Entity', description: 'Error with the provided Query ID.'  }, status: :unprocessable_entity
    end


    private


    # Generate non-repeating Query ID.
    def generate_query_id
        timestamp = (Time.now.to_f * 1_000_000).to_i.to_s # Current time in microseconds.
        sequence = (1 + SecureRandom.random_number(9_999)).to_s.rjust(4, '0') # 4-digit random number, not starting with zero.
        secret = ENV.fetch('SECRET_ID', nil)
        return "#{sequence}#{secret}#{timestamp}"
    end


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
            query_id = generate_query_id

            # Begin Migration process.
            json_data.each do |org|
                # Organisation Check for an Admin User.
                org_admin_status = Common::Helper.org_admin_check(org, administrated_organisations_list)
                administrated_organisations_list << "#{org['scheme-id']}-#{org['identifier-id']}" if org_admin_status == 2

                # Migrate Organisations.
                cii_migration_service_response = cii_org_migration_service.migrate_org(org, org_admin_status)
                ppg_migration_service_response_org = ppg_org_migration_service.migrate_org(org, org_admin_status, cii_migration_service_response[:response_status_code], cii_migration_service_response[:response_body])
                data_migration_service.migrate_org(org, cii_migration_service_response[:response_status_code], ppg_migration_service_response_org[:response_status_code], query_id)

                # Migrate Users.
                org['user'].each do |user|
                    ppg_migration_service_response_user = ppg_user_migration_service.migrate_user(org, user, org_admin_status, ppg_migration_service_response_org[:response_status_code], cii_migration_service_response[:response_body])
                    data_migration_service.migrate_user(org, user, ppg_migration_service_response_user[:response_status_code], query_id)
                end
            end

            # Compile Migration Results into one single report.
            migration_report = {
                query_id: query_id,
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
            }

            # Create Migration Report database entry, to query if needed.
            dm_status = data_migration_service.query_report(query_id, migration_report)

            # Return the Compiled Report for the Completed Migration, in the response.
            return render json: migration_report, status: dm_status.to_i
        else
            return render json: {  error: validator.errors  }, status: :bad_request
        end
    end


    # Process Query ID Requests.
    def process_migration_query(query_id)
        text = "QueryID = #{query_id}.\n\n
        A new DB table that will have at least two columns.
        In this new table, one column will be the query ID, and the second column will be the entire string for the response (trimmed down as much as possible, perhaps start by removing 'migrated data').
        This can then be queried, returned and reformatted back to object.
        A single query ID is generated/assigned per request, regardless of whether it is the same csv, json or user. Always a new Query ID with a new request into DM.
        Also add a new column to the existing users and orgs table, so that the generated query ID is given to new rows too, just in case it's needed."
        return render json: {  Feature_To_Be_Done: text  }, status: :ok
    end
end
