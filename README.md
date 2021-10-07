# Watchlist application's core domain

The core domain of the application.

## Modules

### core

Where the domain actually lies (aggregates, entities, value objects, services, etc)

### infrastructure

The needed boiler plate code to apply the wanted patterns.

### spring-boot-impl

A SpringBoot application that implement the adapters.

## How to launch

The application is served inside a docker image which could be delivered inside a docker container together with postgre:

- Inside the module "spring-boot-impl", run:
-- docker build -t cantu/watchlist .
-- docker-compose up