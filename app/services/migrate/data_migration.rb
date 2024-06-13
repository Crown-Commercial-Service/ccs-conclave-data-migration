module Migrate
  class DataMigration
    def initialize(json_data)
      @data = json_data
      @orgErrorsList = []
      @orgSuccessList = []
      @userErrorsList = []
      @userSuccessList = []
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
        organisation = Organisation.new(
          scheme_id: "#{org["scheme-id"]}",
          identifier_id: "#{org["identifier-id"]}",
          right_to_buy: right_to_boolean("#{org["rightToBuy"]}"),
          domain_name: "#{org["domainName"]}",
          org_roles: get_roles_from_list(org["orgRoles"]),
          status: 200,# Need to do DM last? So it can report on the CII and PPG statuses here. It must be on a per ORG basis, in order to carry on with migration with other orgs/users! !!!!!
          status_description: 'Success.'# Need to do DM last? So it can report on the CII and PPG responses here. It must be on a per ORG basis, in order to carry on with migration with other orgs/users! !!!!!
        )

        if organisation.save
          next @orgSuccessList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: 201, data: organisation  } # Organisation Saved.
        else
          next @orgErrorsList << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, data: org, status_error: organisation.errors, response: nil  } # Organisation Not Saved.
        end
      end

      return {  responses: nil, report: { dm_orgs_success_list: @orgSuccessList, dm_orgs_error_list: @orgErrorsList }  }
    end


    def migrate_users_to_db
      @data.each do |org|
        org["user"].each do |usr|
          user = User.new(
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
            user_roles: get_roles_from_list(usr["userRoles"]),
            status: 201,# Need to do DM last? So it can report on the CII and PPG statuses here. It must be on a per USER basis, in order to carry on with migration with other orgs/users! !!!!!
            status_description: 'Success.'# Need to do DM last? So it can report on the CII and PPG responses here. It must be on a per USER basis, in order to carry on with migration with other orgs/users! !!!!!
          )

          if user.save
            next @userSuccessList << {  user: "#{usr["email"]}", organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: true, status: 201, data: user  } # User Saved.
          else
            next @userErrorsList << {  user: "#{usr["email"]}", organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", success: false, status: 500, data: usr, status_error: user.errors, response: nil  } # User Not Saved.
          end
        end
      end

      return {  responses: nil, report: { dm_users_success_list: @userSuccessList, dm_users_error_list: @userErrorsList }  }
    end


    def get_roles_from_list(roles_list)
      "#{roles_list.map { |role| role["name"] }.join(',')}"
    end


    def right_to_boolean(right_to_buy_string)
      return true if right_to_buy_string.downcase == 'true'

      false
    end
  end
end
