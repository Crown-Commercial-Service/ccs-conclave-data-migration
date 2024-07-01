module Migrate
  class DataMigration
    attr_reader :org_list, :user_list

    def initialize()
      @org_list = []
      @user_list = []
    end


    def migrate_org(org, cii_response_status_code, ppg_org_response_status_code)
      @cii_status_code = cii_response_status_code
      @ppg_org_status_code = ppg_org_response_status_code

      migrate_org_to_db(org)
    end


    def migrate_users(org, ppg_user_response_status_code)
      @ppg_user_status_code = ppg_user_response_status_code

      migrate_users_to_db(org)
    end


    private


    def migrate_org_to_db(org)
      Organisation.new(
        scheme_id: "#{org['scheme-id']}",
        identifier_id: "#{org['identifier-id']}",
        right_to_buy: Common::Helper.org_type_to_boolean("#{org['organisationType']}"),
        domain_name: "#{org['domainName']}",
        org_roles: Common::Helper.get_roles_from_list(org['orgRoles']),
        cii_status: @cii_status_code,
        ppg_status: @ppg_org_status_code
      ).save

      return @org_list << {  organisation: "#{org['scheme-id']}-#{org['identifier-id']}", cii_org_status: @cii_status_code, ppg_org_status: @ppg_org_status_code, migrated_data: org  }
    end


    def migrate_users_to_db(org)
      org['user'].each do |user|
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
          ppg_status: @ppg_user_status_code
        ).save

        next @user_list << {  user: "#{user['email']}", organisation: "#{org['scheme-id']}-#{org['identifier-id']}", ppg_user_status: @ppg_user_status_code, migrated_data: user  }
      end

      return
    end
  end
end
