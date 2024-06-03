module Authorize
  module Token
    def api_key_to_string
      return unless request.headers['x-api-key'].present?

      request.headers['x-api-key'].to_s
    end

    def client_auth
      Client.find_by(api_key: api_key_to_string)
    end

    def authenticate_api_key
      true if client_auth.present?
    end

    def validate_api_key
      render json: { error: "Unauthorized", description: "Please check you provided an x-api-key, and that it is corret." }, status: :unauthorized unless authenticate_api_key
    end
  end
end
