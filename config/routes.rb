Rails.application.routes.draw do
  get '/testing', to: 'testing#test'
  get '/data-migration/migrate/format/:format/:query_id', to: 'data_migration#migration_query', constraints: { format: /(csv|json)/ }
  post '/data-migration/migrate/format/csv', to: 'data_migration#validate_as_csv'
  post '/data-migration/migrate/format/json', to: 'data_migration#validate_as_json'
  
  # Health check route
  match '/health_check', to: proc { [200, {}, ['success']] }, via: [:get]

  # Root route to respond with a 404 JSON response
  root to: proc { [404, { 'Content-Type' => 'application/json' }, [{ error: 'Not Found', description: 'The requested resource does not exist.' }.to_json]] }
end
