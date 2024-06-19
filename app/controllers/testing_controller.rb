require 'csv'
require 'uri'
require 'net/http'


# To be deleted. This is just a convenient place to test random bits.
class TestingController < ApplicationController
    include Authorize::Token
    before_action :validate_api_key


    def test
        # contactPoint = { name: "", email: "test@test.com" }
        # data = nil
        # puts data.present?
        # response = {  request: request, response: Struct.new(:code).new(409), error: "CII returned 409 Conflict for this org. Organisation already exists in PPG."  }
        # puts response[:response].code
    end
end
