Rails.application.routes.draw do
  post '/data-migration/migrate/format/csv', to: 'data_migration#migrate'
end
