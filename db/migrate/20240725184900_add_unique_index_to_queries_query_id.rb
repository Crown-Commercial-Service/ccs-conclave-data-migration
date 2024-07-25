class AddUniqueIndexToQueriesQueryId < ActiveRecord::Migration[7.1]
  def change
    add_index :queries, :query_id, unique: true
  end
end
