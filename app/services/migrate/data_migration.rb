module Migrate
  class DataMigration
    def initialize(json_data, cii_org_status_codes_list, ppg_org_status_codes_list, ppg_user_status_codes_list)
      @data = json_data
      @cii_org_statuses = cii_org_status_codes_list
      @ppg_org_statuses = ppg_org_status_codes_list
      @ppg_user_statuses = ppg_user_status_codes_list

      @org_list = []
      @user_list = []
    end


    def migrate_orgs
      migrate_orgs_to_db
    end


    def migrate_users
      migrate_users_to_db
    end


    private


    def migrate_orgs_to_db
      @data.each do |org|
        Organisation.new(
          scheme_id: "#{org["scheme-id"]}",
          identifier_id: "#{org["identifier-id"]}",
          right_to_buy: Common::Helper.org_type_to_boolean("#{org["organisationType"]}"),
          domain_name: "#{org["domainName"]}",
          org_roles: Common::Helper.get_roles_from_list(org["orgRoles"]),
          cii_status: @cii_org_statuses["#{org["scheme-id"]}-#{org["identifier-id"]}"][:status],
          ppg_status: @ppg_org_statuses["#{org["scheme-id"]}-#{org["identifier-id"]}"][:status]
        ).save

          next @org_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", cii_org_status: @cii_org_statuses["#{org["scheme-id"]}-#{org["identifier-id"]}"][:status], ppg_org_status: @ppg_org_statuses["#{org["scheme-id"]}-#{org["identifier-id"]}"][:status], migrated_data: org  }
      end

      return {  responses: nil, reports: {  report: @org_list  }, statuses: nil  }
    end


    def migrate_users_to_db
      @data.each do |org|
        org["user"].each do |usr|
          User.new(
            scheme_id: "#{org["scheme-id"]}",
            identifier_id: "#{org["identifier-id"]}",
            contact_email: "#{usr["contactEmail"]}",
            contact_mobile: "#{usr["contactMobile"]}",
            contact_phone: "#{usr["contactPhone"]}",
            contact_fax: "#{usr["contactFax"]}",
            contact_social: "#{usr["contactSocial"]}",
            email: "#{usr["email"]}",
            title: "#{usr["title"]}",
            first_name: "#{usr["firstName"]}",
            last_name: "#{usr["lastName"]}",
            user_roles: Common::Helper.get_roles_from_list(usr["userRoles"]),
            ppg_status: 123#@ppg_user_statuses["#{org["scheme-id"]}-#{org["identifier-id"]}"][:status]
          ).save

          next @user_list << {  user: "#{usr["email"]}", organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", ppg_user_status: 123, migrated_data: usr  }#@ppg_user_statuses["#{org["scheme-id"]}-#{org["identifier-id"]}"][:status]
        end
      end

      return {  responses: nil, reports: {  report: @user_list  }, statuses: nil  }
    end
  end
end
