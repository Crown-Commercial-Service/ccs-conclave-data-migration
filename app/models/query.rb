class Query < ApplicationRecord
  validates :query_id, :migration_report, presence: true
end
