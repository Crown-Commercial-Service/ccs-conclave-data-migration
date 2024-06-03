# JsonValidator class responsible for validating JSON data against specific requirements/conditions.
module Validate
  class JsonValidator
    attr_reader :errors

    def initialize
      @errors = []
    end

    def validate(data)
      # Validate that 'data' is an array
      return false unless validate_json_array(data)

      # Validate each organization entry in the array
      data.each do |org_data|
        return false unless validate_organization(org_data)
      end

      # If all validations pass, return true
      true
    end

    private

    def validate_json_array(data)
      begin
        json_data = data.is_a?(String) ? JSON.parse(data) : data
        return json_data.is_a?(Array)
      rescue JSON::ParserError
        @errors << "Invalid JSON array format."
        return false
      end
    end


    def validate_organization(org_data)
      # Validate required fields for organization
      return false unless org_data.key?("identifier-id") &&
                          org_data.key?("scheme-id") &&
                          org_data.key?("rightToBuy") &&
                          org_data.key?("domainName") &&
                          org_data.key?("orgRoles") &&
                          org_data.key?("user") &&
                          org_data["user"].is_a?(Array)

      # Validate each user entry in the organization
      org_data["user"].each do |user_data|
        return false unless validate_user(user_data)
      end

      # If all validations pass, return true
      true
    end

    def validate_user(user_data)
      # Validate required fields for user
      return false unless user_data.key?("email") &&
                          user_data.key?("title") &&
                          user_data.key?("firstName") &&
                          user_data.key?("lastName") &&
                          user_data.key?("contactEmail") &&
                          user_data.key?("contactMobile") &&
                          user_data.key?("contactPhone") &&
                          user_data.key?("contactFax") &&
                          user_data.key?("contactSocial") &&
                          user_data.key?("userRoles") &&
                          user_data["userRoles"].is_a?(Array)

      # If all validations pass, return true
      true
    end
  end
end
