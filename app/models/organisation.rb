class Organisation < ApplicationRecord
  validates :identifier_id, :scheme_id, :domain_name, :query_id, presence: true
end
