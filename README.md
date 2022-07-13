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

## Run locally

You can run Data Migration and its database locally. However, it needs access to Vault, CII, and SSO, which we can't run locally. So we have a script that runs the application against a local database, but using the Vault, CII, and SSO from the sandbox environment.

You need to have `docker` and `cf` installed, and have access to the sandbox space in our GOV.UK PaaS organisation.

1. Run `docker run --rm -p 5432:5432 -e POSTGRES_PASSWORD=test postgres:13`
2. In another terminal window, run `./run-locally.sh`
3. Access the application at `http://localhost:8080`

## Generating server stub and API clients

The server interface and CII and SSO clients are generated using [swagger-codegen](https://github.com/swagger-api/swagger-codegen) from [OpenAPI specs](src/main/resources).

We use v3.0.27 to avoid [a bug in more recent versions](https://github.com/swagger-api/swagger-codegen/issues/11317). Download it from <https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.27/swagger-codegen-cli-3.0.27.jar> and copy it to `swagger-codegen-cli.jar`.

To update, run:

```
java -jar swagger-codegen-cli.jar generate --output . --config src/main/resources/cii_config.json --input-spec src/main/resources/cii_api.yaml --lang java
java -jar swagger-codegen-cli.jar generate --output . --config src/main/resources/conclave_config.json --input-spec src/main/resources/conclave_api.yaml --lang java
java -jar swagger-codegen-cli.jar generate --output . --config src/main/resources/dm_config.json --input-spec src/main/resources/dm_api.yaml --lang spring
```

## Database migrations

We use [liquibase](https://docs.liquibase.com/home.html) to manage the database. Migrations are defined in [`master.xml`](src/main/resources/db/changelog/master.xml).

We do not yet know how to run the database migrations securely in production. We have a less secure process you can use in other environments:

1. Install liquibase: `brew install liquibase`
2. Install the conduit plugin for Cloudfoundry: `cf install-plugin conduit`
3. Find the name of the database service in your chosen non-production environment
4. Run `cf conduit <database service name> -- ./run-db-migrations.sh`
