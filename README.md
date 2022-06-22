# ccs-conclave-data-migration
Conclave Data Migration project.

[![Build Status](https://app.travis-ci.com/Crown-Commercial-Service/ccs-conclave-data-migration.svg?branch=develop)](https://app.travis-ci.com/Crown-Commercial-Service/ccs-conclave-data-migration)

# Description

The Public Procurement Gateway (PPG; previously known as Conclave) is a new single sign-on platform for users of CCS services. Some CCS services will soon start using PPG. To avoid users needing to re-enter all their information, we want to migrate their existing information from the various different services to PPG.

Data Migration is an application that the various services will use to migrate buyer and supplier data for both organisations and users to PPG.

# Specification
This application provides an implementation of the [REST API](https://app.swaggerhub.com/apis/miahnanu/datamigration/1.0.0-oas3#/datamigration/app.migrateOrg) that will be used to post user data into conclave.

# Developing

This project uses Java 11 and Maven. To run the tests, ensure that `JAVA_HOME` is set, then run `./mvnw test`.

CCS people can view [the internal quickstart guide](https://crowncommercialservice.atlassian.net/wiki/spaces/CON/pages/3373465612) that lists all the access and permissions you should ask for.

## Generating API clients

The CII and SSO clients are generated using [swagger-codegen](https://github.com/swagger-api/swagger-codegen) from [OpenAPI specs](src/main/resources). 

To update, run:

```
swagger-codegen generate --output . --config src/main/resources/cii_config.json --input-spec src/main/resources/cii_api.yaml --lang java -DapiTests=false -DmodelTests=false -DapiDocs=false -DmodelDocs=false
swagger-codegen generate --output . --config src/main/resources/conclave_config.json --input-spec src/main/resources/conclave_api.yaml --lang java -DapiTests=false -DmodelTests=false -DapiDocs=false -DmodelDocs=false
```
