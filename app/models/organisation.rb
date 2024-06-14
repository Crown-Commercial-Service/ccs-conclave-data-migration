class Organisation < ApplicationRecord
  validates :identifier_id, :scheme_id, :domain_name, presence: true
end
