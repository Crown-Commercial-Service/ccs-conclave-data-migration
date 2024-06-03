class User < ApplicationRecord
  validates :email, presence: true, uniqueness: { case_sensitive: false }
  validates :identifier_id, :scheme_id, :first_name, :last_name, presence: true
end
