# CsvValidator class responsible for validating CSV data against specific requirements.
class CsvValidator
  attr_reader :errors

  def initialize(csv_data)
    @csv_data = csv_data
    @errors = []
    @line_no = 0
  end

  def validate
    # Validate that the CSV file is not empty.
    return false if @csv_data.nil?

    # Define a list of fields that are required
    required_fields = %w[IdentifierId SchemeId OrganisationType EmailAddress Title FirstName LastName]

    # Validate that each required field exists and is not blank in each row of the CSV data.
    @csv_data.each do |row|
      @line_no += 1

      next if @line_no == 1

      required_fields.each do |field|
          value = row[field]

          # Check that the value exists and is not blank.
          if value.nil? || value.empty?
              @errors << "Row #{@line_no}: '#{field}' field is required and cannot be blank"
          elsif field == "EmailAddress" && !valid_email?(value)
              @errors << "Row #{@line_no}: '#{field}' field must be a valid email address"
          elsif %w[ContactMobile ContactPhone].include?(field) && !valid_phone_number?(value)
              @errors << "Row #{@line_no}: '#{field}' field must be a valid phone number"
          end
      end

      # Validate optional fields if present.
      optional_fields = %w[OrganisationRoles UserRoles ContactName ContactEmail ContactMobile ContactPhone ContactFax ContactSocial]
      optional_fields.each do |field|
          value = row[field]
          if !value.nil? && !value.empty?
              if field == "ContactEmail" && !valid_email?(value)
                  @errors << "Row #{@line_no}: '#{field}' field must be a valid email address"
              elsif %w[ContactMobile ContactPhone].include?(field) && !valid_phone_number?(value)
                  @errors << "Row #{@line_no}: '#{field}' field must be a valid phone number"
              end
          end
      end
    end

    # Return true if there are no errors, false otherwise.
    @errors.empty?
  end  

  private

  def valid_email?(email)
    # Use a regular expression to validate that the email address is valid.
    # This is a simplified regex that matches most common email address formats.
    # For more complex validation, a more robust regex or third-party library could be used.
    email_regex = /\A[\w+\-.]+@[a-z\d\-]+(\.[a-z\d\-]+)*\.[a-z]+\z/i
    email_regex.match?(email)
  end

  def valid_phone_number?(phone_number)
    # Use a regular expression to validate that the phone number is valid.
    # This regex matches numbers that are numerical, start with a plus character, and can have spaces in between numbers.
    # For more complex validation, a more robust regex or third-party library could be used.
    phone_regex = /\A\+?[0-9 ]+\z/
    phone_regex.match?(phone_number)
  end
end