module Migrate
  class DataMigration
    attr_reader :org_list, :user_list

    def initialize()
      @org_list = []
      @user_list = []
    end


    def migrate_org(org, cii_response_status_code, ppg_org_response_status_code, query_id)
      @cii_status_code = cii_response_status_code
      @ppg_org_status_code = ppg_org_response_status_code

      migrate_org_to_db(org, query_id)
    end


    def migrate_user(org, user, ppg_user_response_status_code, query_id)
      @ppg_user_status_code = ppg_user_response_status_code

      migrate_user_to_db(org, user, query_id)
    end


    def query_report(query_id, report)
      create_migration_query_report(query_id, report)
    end


    private


    def migrate_org_to_db(org, query_id)
      Organisation.new(
        scheme_id: "#{org['scheme-id']}",
        identifier_id: "#{org['identifier-id']}",
        right_to_buy: Common::Helper.org_type_to_boolean("#{org['organisationType']}"),
        domain_name: "#{org['domainName']}",
        org_roles: Common::Helper.get_roles_from_list(org['orgRoles']),
        cii_status: @cii_status_code,
        ppg_status: @ppg_org_status_code,
        query_id: query_id
      ).save

      return @org_list << {  organisation: "#{org['scheme-id']}-#{org['identifier-id']}", cii_org_status: @cii_status_code, ppg_org_status: @ppg_org_status_code, migrated_data: org  }
    end


    def migrate_user_to_db(org, user, query_id)
      User.new(
        scheme_id: "#{org['scheme-id']}",
        identifier_id: "#{org['identifier-id']}",
        contact_email: "#{user['contactEmail']}",
        contact_mobile: "#{user['contactMobile']}",
        contact_phone: "#{user['contactPhone']}",
        contact_fax: "#{user['contactFax']}",
        contact_social: "#{user['contactSocial']}",
        email: "#{user['email']}",
        first_name: "#{user['firstName']}",
        last_name: "#{user['lastName']}",
        user_roles: Common::Helper.get_roles_from_list(user['userRoles']),
        ppg_status: @ppg_user_status_code,
        query_id: query_id
      ).save

      return @user_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", ppg_user_status: @ppg_user_status_code, migrated_data: user  }
    end


    def create_migration_query_report(query_id, migration_report)
      query = Query.new(
        query_id: query_id,
        migration_report: migration_report
      )

      if query.save
        return 200
        #return { status: 200, message: "Report successfully saved." }
      else
        return 400
        #return { status: 400, message: "Failed to save report.", errors: query.errors }
      end

    rescue StandardError => err
      Common::Helper.log_error(err)
      return 500
      #return { status: 500, message: "Internal server error occurred.", error: err.message }
    end
  end
end
