module Common
  class Helper

    def self.org_type_to_boolean(org_type)
      return true if org_type == 1 || org_type == "1" || org_type == 2 || org_type == "2"

      false
    end


    def self.parse_comma_separated_list(data_list)
      data_list.split(',').map { |item| { "name" => item.strip } }
    end


    def self.get_roles_from_list(roles_list)
      "#{roles_list.map { |role| role["name"] }.join(',')}"
    end


    def self.log_error(err)
      puts "Error: #{err.message}"
      puts err.backtrace.join("\n")
    end
  end
end
