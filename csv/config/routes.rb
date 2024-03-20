Rails.application.routes.draw do
  post '/data-migration/migrate/format/csv', to: 'data_migration#migrate'
  match '/health_check', to: proc { [200, {}, ['success']] }, via: [:get]
end
