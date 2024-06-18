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
    end
end
