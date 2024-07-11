module Common
  class Helper

    def self.org_type_to_boolean(org_type)
      return true if org_type == 1 || org_type == '1' || org_type == 2 || org_type == '2'

      false
    end


    def self.parse_comma_separated_list(data_list)
      data_list.split(',').map { |item| { 'key' => item.strip } }
    end


    def self.get_roles_from_list(roles_list)
      "#{roles_list.map { |role| role['key'] }.join(',')}"
    end


    # Checks whether an organisation users list has at least one org admin, and returns an integer for the results of this check.
    def self.org_admin_check(org, admin_orgs_list)
      return 1 if admin_orgs_list.include?("#{org['scheme-id']}-#{org['identifier-id']}") # Admin found.

      org['user'].each do |user|
          user['userRoles'].each do |role|
              return 2 if role['key'].upcase == 'ORG_ADMINISTRATOR' # Admin found.
          end
      end
      return 0 # No Admin found.
  end


    def self.log_error(err)
      puts "Error: #{err.message}"
      puts err.backtrace.join("\n")
    end
  end
end
