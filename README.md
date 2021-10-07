# Watchlist application's core domain

The core domain of the application.

## Modules

### core

Where the domain actually lies (aggregates, entities, value objects, services, etc).Z

### spring-boot-impl

A SpringBoot application that implement the adapters.

## How to launch

The application is served inside a docker image which could be delivered inside a docker container together with postgre:

- Inside the module "spring-boot-impl", run:

```
docker-compose up
```