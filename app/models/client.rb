class Client < ApplicationRecord
  validates :client_id, :client_key_description, :api_key, presence: true
  before_validation :client_api_key

  private

  def client_api_key
    self.api_key = SecureRandom.hex(40).to_s
  end
end
