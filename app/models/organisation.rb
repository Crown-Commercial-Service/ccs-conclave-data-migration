class Organisation < ApplicationRecord
  validates :identifier_id, presence: true, uniqueness: { case_sensitive: false }
  validates :scheme_id, :domain_name, presence: true
end
