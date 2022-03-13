# Spring Boot Reactive and Mongo Db Demo

A simple demo project that uses Spring Boot, Webflux reactive streams and Mongo db to provide
with reactive stream crud operations.

### The project has one endpoint to get data and save them in the db /api/{cityId}/{pagesize}.

We use the UK government api for food and safety.

You can specify as Id a random integer up to 500. Each id represents a city in UK.
The endpoint will return a list of establishments which we save to our Mongo db.

Afterwards you can query the already saved objects in the db to get a list of them, update and delete them.

# How to run it locally

Use `docker-compose up -d` in order for the docker image of the db to run.
Then you can use `./gradlew bootRun` for the application to start.

# Requirements

- Java 17 
- Docker 