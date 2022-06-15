# ccs-conclave-data-migration
Conclave Data Migration project.

[![Build Status](https://app.travis-ci.com/Crown-Commercial-Service/ccs-conclave-data-migration.svg?branch=develop)](https://app.travis-ci.com/Crown-Commercial-Service/ccs-conclave-data-migration)

# Description
A generic migration application for both buyers and suppliers. This application will create organisations and users in Conclave(A single sign-on platform) using buyer and supplier data supplied by CCS platforms and services. 

# Specification
This application provides an implementation of the [REST API](https://app.swaggerhub.com/apis/miahnanu/datamigration/1.0.0-oas3#/datamigration/app.migrateOrg) that will be used to post user data into conclave.

# Developing

This project uses Java 11 and Maven. To run the tests, ensure that `JAVA_HOME` is set, then run `./mvnw test`.
