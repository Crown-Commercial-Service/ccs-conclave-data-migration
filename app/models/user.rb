class User < ApplicationRecord
  validates :email, :identifier_id, :scheme_id, :first_name, :last_name, presence: true
end
