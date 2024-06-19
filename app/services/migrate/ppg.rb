require 'net/http'
require 'uri'

module Migrate
  class Ppg
    def initialize(json_data, cii_response_list, cii_status_list)
      @data = json_data
      @cii_responses = cii_response_list
      @cii_statuses = cii_status_list
      @org_error_list = []
      @org_success_list = []
      @user_error_list = []
      @user_success_list = []
      @org_response_status_code_list = {}
      @user_response_status_code_list = {}
    end


    def migrate_orgs
      migrate_orgs_to_ppg
    end


    def migrate_users
      migrate_users_to_ppg
    end


    private


    def migrate_orgs_to_ppg
      @data.each do |org|
        response = send_request_to_ppg('/organisation-profile', org)

        if response.present? && response[:response].present? && response[:response].code.present?
          @org_response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: response[:response].code.to_i  }

          if response[:response].code.to_i == 200 || response[:response].code.to_i == 201
            next @org_success_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: response[:response].code.to_i, org_contact_response: add_organisation_contact(org)  } # Organisation Migrated to PPG.
          elsif response[:response].code.to_i == 409
            next @org_success_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: true, status: response[:response].code.to_i, org_contact_response: nil  } # Organisation Already Migrated to PPG.
          else
            next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: response[:response].code.to_i, status_error: 'Unsuccessful Response from PPG. Organisation Not Migrated to PPG.', response: response  } # Organisation Not Migrated to PPG.
          end
        else
          @org_response_status_code_list["#{org["scheme-id"]}-#{org["identifier-id"]}"] = {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", status: 500  }
          next @org_error_list << {  organisation: "#{org["scheme-id"]}-#{org["identifier-id"]}", successful: false, status: 500, status_error: response[:error], response: response  } # Organisation Not Migrated to PPG.
        end
      end

      return {  responses: nil, reports: {  success_report: @org_success_list, error_report: @org_error_list  }, statuses: @org_response_status_code_list  }
    end


    def add_organisation_contact(org)
      return 500 if @cii_responses["#{org["scheme-id"]}-#{org["identifier-id"]}"].blank? || JSON.parse(@cii_responses["#{org["scheme-id"]}-#{org["identifier-id"]}"])['organisationId'].blank?

      response = send_request_to_ppg("/contact-service/organisations/#{JSON.parse(@cii_responses["#{org["scheme-id"]}-#{org["identifier-id"]}"])['organisationId']}/registry-contact", org)

      return response[:response].code.to_i if response.present? && response[:response].present? && response[:response].code.present?

      return 500
    end


    def send_request_to_ppg(endpoint, data = nil)
      uri = URI.parse(ENV.fetch('PPG_DOMAIN', nil) + endpoint)

      http = Net::HTTP.new(uri.host, uri.port)
      if ENV.fetch('REMOTE_APP', nil) == 'true'
        http.use_ssl = true
      else
        http.use_ssl = true
      end

      case endpoint
      when '/organisation-profile'
        request = Net::HTTP::Post.new(uri.request_uri)
        request["Content-Type"] = "application/json"
        request["x-api-key"] = ENV.fetch('PPG_ORG_API_KEY', nil)
        request.body = build_org_post_body(data)
      when ->(e) { e.start_with?('/contact-service/organisations') }
        request = Net::HTTP::Post.new(uri.request_uri)
        request["Content-Type"] = "application/json"
        request["x-api-key"] = ENV.fetch('PPG_ORG_CONTACT_API_KEY', nil)
        request.body = build_org_contact_patch_body(data)
      else
        request = Net::HTTP::Get.new(uri.request_uri)
        request["x-api-key"] = ENV.fetch('PPG_ORG_API_KEY', nil)
      end

      if data.present? && request.body == nil
        return {  request: request, response: Struct.new(:code).new(@cii_statuses["#{data["scheme-id"]}-#{data["identifier-id"]}"][:status].to_i), error: nil  }
      end

      begin
        response = http.request(request)
        return {  request: request, response: response, error: nil  }

      rescue StandardError => err
        Common::Helper.log_error(err)
        return {  request: request, response: nil, error: err  }
      end

      {  request: nil, response: nil, error: nil  } # Fallback, to avoid 500 errors.
    end


    def build_org_post_body(data)
      return nil if data.blank? || @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"].blank?

      cii_org_data = JSON.parse(@cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"])

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
      return nil if data.blank? || @cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"].blank? || JSON.parse(@cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"])['contactPoint'].blank?

      cii_org_data = JSON.parse(@cii_responses["#{data["scheme-id"]}-#{data["identifier-id"]}"])
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
