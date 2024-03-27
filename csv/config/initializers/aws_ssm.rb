require 'aws-sdk-ssm'

private

def config_aws
    ssm_client = initialize_ssm_client
    params_list = fetch_params_list(ssm_client)
    set_env(ssm_client, params_list) if ssm_client && params_list.any?
end

def initialize_ssm_client
     vcap_services = nil
     ssm_client = nil
     vcap_services = JSON.parse(ENV['VCAP_SERVICES'])

     vcap_services['user-provided'].each do |user_service|
      if user_service['credentials']['aws_access_key_id'].present?
        ssm_client = Aws::SSM::Client.new(
          region: user_service['credentials']['region'],
          access_key_id: user_service['credentials']['aws_access_key_id'],
          secret_access_key: user_service['credentials']['aws_secret_access_key']
        )
       end
     end
    ssm_client
end

def fetch_params_list(ssm_client)
    next_token = nil
    params_list = []
  
    begin
      loop do
        response = ssm_client.describe_parameters({ max_results: 50, next_token: next_token })
        params_list += response.parameters.map(&:name).select { |name| name.include?("/conclave-data-migration/") }
        next_token = response.next_token
        break if next_token.nil?
    end
    rescue Aws::SSM::Errors::ServiceError => e
        puts "Error fetching parameters: #{e.message}"
    end
    params_list
end

def set_env(ssm_client, params_list)
    params_list.each do |param_name|
        response = ssm_client.get_parameter({ name: "#{param_name}", with_decryption: true})
        env_param_name = param_name.gsub("/conclave-data-migration/", "").to_s
        ENV[env_param_name.upcase] = response.parameter.value
	end
end

#config_aws
