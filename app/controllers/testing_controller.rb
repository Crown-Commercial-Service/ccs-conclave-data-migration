require 'csv'
require 'uri'
require 'net/http'


# To be deleted. This is just a convenient place to test random bits.
class TestingController < ApplicationController
    include Authorize::Token
    before_action :validate_api_key


    def test
        # timestamp = (Time.now.to_f * 1_000_000).to_i.to_s # Current time in microseconds.
        # sequence = SecureRandom.random_number(10_000).to_s.rjust(4, '0') # 4-digit random number.
        # secret = ENV.fetch('SECRET_ID', nil)
        # puts "#{sequence}#{secret}#{timestamp}"
        # contactPoint = { name: "", email: "test@test.com" }
        # data = nil
        # puts data.present?
        # response = {  request: request, response: Struct.new(:code).new(409), error: "CII returned 409 Conflict for this org. Organisation already exists in PPG."  }
        # puts response[:response].code

        #test = '{:query_id=>"123456", :dm_report=>{:orgs=>[{:organisation=>"...."}], :error_report=>[]}}}'
        #m_test = eval(test)
        #render json: m_test, status: :ok
    end
end
