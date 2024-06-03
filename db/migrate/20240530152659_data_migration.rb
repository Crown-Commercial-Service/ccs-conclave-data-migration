class DataMigration < ActiveRecord::Migration[7.1]
  def change
    create_table :clients, id: false do |t|
      t.bigserial :client_id, primary_key: true
      t.string :api_key, null: false
      t.string :client_key_description

      t.timestamps
    end

    add_index :clients, [:client_id, :api_key], unique: true

    create_table :organisations, id: false do |t|
      t.bigserial :org_id, primary_key: true
      t.string :identifier_id, null: false
      t.string :org_roles
      t.boolean :right_to_buy
      t.string :scheme_id, null: false
      t.integer :status
      t.string :status_description
      t.string :domain_name

      t.timestamps
    end

    add_index :organisations, [:org_id, :identifier_id], unique: true

    create_table :users, id: false do |t|
      t.bigserial :user_id, primary_key: true
      t.string :contact_email
      t.string :contact_fax
      t.string :contact_mobile
      t.string :contact_phone
      t.string :contact_social
      t.string :email, null: false
      t.string :first_name, null: false
      t.string :last_name, null: false
      t.integer :status
      t.string :status_description
      t.string :title
      t.string :user_roles
      t.string :identifier_id, null: false
      t.string :scheme_id, null: false

      t.timestamps
    end

    add_index :users, [:user_id, :email], unique: true
  end
end
