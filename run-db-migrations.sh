#!/usr/bin/env bash
set -eou pipefail

# Because we're disabling SSL for the connection, so are vulnerable to man-in-the-middle attacks.
echo "This script is not secure. Don't use it in production"

liquibase update \
  --changelog-file src/main/resources/db/changelog/master.xml \
  --defaults-file src/main/resources/liquibase.properties \
  --url "$(jq -nr 'env.VCAP_SERVICES | fromjson | .postgres[].Credentials.jdbcuri')&ssl=false"
