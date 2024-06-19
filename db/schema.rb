# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# This file is the source Rails uses to define your schema when running `bin/rails
# db:schema:load`. When creating a new database, `bin/rails db:schema:load` tends to
# be faster and is potentially less error prone than running all of your
# migrations from scratch. Old migrations may fail to apply correctly if those
# migrations use external dependencies or application code.
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema[7.1].define(version: 2024_05_30_152659) do
  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "clients", primary_key: "client_id", force: :cascade do |t|
    t.string "api_key", null: false
    t.string "client_key_description"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["client_id", "api_key"], name: "index_clients_on_client_id_and_api_key", unique: true
  end

  create_table "organisations", primary_key: "org_id", force: :cascade do |t|
    t.string "identifier_id", null: false
    t.string "org_roles"
    t.boolean "right_to_buy"
    t.string "scheme_id", null: false
    t.integer "cii_status"
    t.integer "ppg_status"
    t.string "domain_name"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["org_id"], name: "index_organisations_on_org_id", unique: true
  end

  create_table "users", primary_key: "user_id", force: :cascade do |t|
    t.string "contact_email"
    t.string "contact_fax"
    t.string "contact_mobile"
    t.string "contact_phone"
    t.string "contact_social"
    t.string "email", null: false
    t.string "first_name", null: false
    t.string "last_name", null: false
    t.integer "ppg_status"
    t.string "user_roles"
    t.string "identifier_id", null: false
    t.string "scheme_id", null: false
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["user_id"], name: "index_users_on_user_id", unique: true
  end

end
