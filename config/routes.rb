Rails.application.routes.draw do
  post '/data-migration/migrate/format/csv', to: 'data_migration#validate_as_csv'
  post '/data-migration/migrate/format/json', to: 'data_migration#validate_as_json'
  match '/health_check', to: proc { [200, {}, ['success']] }, via: [:get]
end
