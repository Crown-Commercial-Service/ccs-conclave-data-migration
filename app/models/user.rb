class User < ApplicationRecord
  validates :email, :identifier_id, :scheme_id, :first_name, :last_name, :query_id, presence: true
end
