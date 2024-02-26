#!/usr/bin/env bash
set -eoux pipefail

cf target -s sandbox

liquibase update \
  --changelog-file src/main/resources/db/changelog/master.xml \
  --defaults-file src/main/resources/liquibase.properties \
  --url jdbc:postgresql://localhost:5432/postgres \
  --username postgres \
  --password test

set +x
export VCAP_SERVICES=$(
  cf ssh ccs-conclave-data-migration -c 'echo $VCAP_SERVICES' | jq -r '{"hashicorp-vault": ."hashicorp-vault"}'
)
export VAULT_TOKEN=$(
  cf ssh ccs-conclave-data-migration -c 'echo $VAULT_TOKEN'
)
set -x

./mvnw spring-boot:run
