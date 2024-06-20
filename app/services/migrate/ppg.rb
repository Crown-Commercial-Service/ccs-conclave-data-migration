require 'net/http'
require 'uri'

module Migrate
  class Ppg
    attr_reader :org_success_list, :org_error_list, :user_success_list, :user_error_list

    def initialize()
      @org_success_list = []
      @org_error_list = []
      @user_success_list = []
      @user_error_list = []
    end


    def migrate_org(org, org_admin_status, cii_response_status_code, cii_response_body)
      @admin_check = org_admin_status
      @cii_status_code = cii_response_status_code
      @cii_body = cii_response_body

      migrate_org_to_ppg(org)
    end


    def migrate_users(org)
      migrate_users_to_ppg(org)
    end


    private


    def migrate_org_to_ppg(org)
      response = send_request_to_ppg('/organisation-profile', org)

      if response.present? && response[:response].present? && response[:response].code.present?
        if response[:response].code.to_i == 200 || response[:response].code.to_i == 201 || response[:response].code.to_i == 409
          org_contact_response = 409
          org_contact_response = add_organisation_contact(org) if response[:response].code.to_i != 409
          @org_success_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: response[:response].code.to_i, org_contact_status: org_contact_response  } # Organisation Migrated or Already Exists.
          return {  response_status_code: response[:response].code.to_i, response_body: nil  }
        else
          @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response[:response].code.to_i, status_description: response[:status_description], response: response  } # Organisation Not Migrated.
          return {  response_status_code: response[:response].code.to_i, response_body: nil  }
        end
      else
        @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, status_description: response[:status_description], response: response  } # Organisation Not Migrated.
        return {  response_status_code: 500, response_body: nil  }
      end
    end


    def add_organisation_contact(org)
      return 500 if @cii_body.blank? || JSON.parse(@cii_body)['organisationId'].blank?

      response = send_request_to_ppg("/contact-service/organisations/#{JSON.parse(@cii_body)['organisationId']}/registry-contact", org)

      return response[:response].code.to_i if response.present? && response[:response].present? && response[:response].code.present?

      return 500
    end


    def send_request_to_ppg(endpoint, data = nil)
      return {  request: nil, response: Struct.new(:code).new(400), status_description: 'No Organisation Administrator found for this Organisation. Organisation Not Created in PPG'  } if @admin_check == 0
      return {  request: nil, response: Struct.new(:code).new(409), status_description: 'Organisation Already Exists in CII. Duplicate Organisation Not Created in PPG'  } if @cii_status_code == 409
      return {  request: nil, response: Struct.new(:code).new(403), status_description: 'Unsuccessful Response from CII. Organisation Not Created in PPG'  } unless (200..201).include?(@cii_status_code)

      uri = URI.parse(ENV.fetch('PPG_DOMAIN', nil) + endpoint)
      http = Net::HTTP.new(uri.host, uri.port)
      http.use_ssl = true # Set to false, if using HTTP (or locally hosting).

      case endpoint
      when '/organisation-profile'
        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_ORG_API_KEY', nil)
        request["Content-Type"] = "application/json"
        request.body = build_org_post_body(data)
      when ->(e) { e.start_with?('/contact-service/organisations') }
        request = Net::HTTP::Post.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_ORG_CONTACT_API_KEY', nil)
        request["Content-Type"] = "application/json"
        request.body = build_org_contact_patch_body(data)
      else
        request = Net::HTTP::Get.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_ORG_API_KEY', nil)
      end

      if data.present? && request.body == nil
        return {  request: request, response: Struct.new(:code).new(500), status_description: 'Internal Error.'  }
      end

      begin
        response = http.request(request)
        return {  request: request, response: response, status_description: 'Unsuccessful Response from PPG. Organisation Not Created in PPG.'  } # This 'status_description' is hidden in responses, unless needed to be displayed in a negative scenario.

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, status_description: err  }
      end

      {  request: nil, response: nil, status_description: 'Internal Error.'  } # Fallback, to prevent 500 errors.
    end


    def build_org_post_body(data)
      return nil if data.blank? || @cii_body.blank?

      cii_org_data = JSON.parse(@cii_body)

      return {
        identifier: cii_org_data['identifier'],
        additionalIdentifiers: cii_org_data['additionalIdentifier'],
        address: cii_org_data['address'],
        detail: {
          organisationId: cii_org_data['organisationId'],
          supplierBuyerType: data["organisationType"].to_i,
          rightToBuy: Common::Helper.org_type_to_boolean("#{data["organisationType"]}"),
          isActive: true,
          domainName: data["domainName"]
        }
      }.to_json
    end


    def build_org_contact_patch_body(data)
      return nil if data.blank? || @cii_body.blank? || JSON.parse(@cii_body)['contactPoint'].blank?

      cii_org_data = JSON.parse(@cii_body)
      org_contacts = []

      if cii_org_data['contactPoint']['email'].present?
        org_contacts << {  contactType: "EMAIL", contactValue: cii_org_data['contactPoint']['email']  }
      end

      if cii_org_data['contactPoint']['telephone'].present?
        org_contacts << {  contactType: "PHONE", contactValue: cii_org_data['contactPoint']['telephone']  }
      end

      if cii_org_data['contactPoint']['faxNumber'].present?
        org_contacts << {  contactType: "FAX", contactValue: cii_org_data['contactPoint']['faxNumber']  }
      end

      if cii_org_data['contactPoint']['uri'].present?
        org_contacts << {  contactType: "WEB_ADDRESS", contactValue: cii_org_data['contactPoint']['uri']  }
      end

      return {
        address: cii_org_data['address'],
        contactPointName: "#{cii_org_data['contactPoint']['name']}",
        contacts: org_contacts
      }.to_json
    end
  end
end
