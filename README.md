# Phone Service Management

A Microservice for managing Phone Service Counter queue and business process.

List of Services:

1. EurekaServer -> A Eureka Server for Managing Available Microservices
2. ServiceManagement -> A Microservice for Master Data API to handle CRUD to master data
3. ServiceManagementCoreV2 -> A Microservice for handling data modification and process logic.

# How To Run and Use

1. Run EurekaServer -> Eureka Dashboard can be accessed using http://localhost:8761
2. Run ServiceManagement -> Swagger UI can be accessed using http://localhost:8090/swagger-ui.html

- This will also initiate initial data to database

3. Run ServiceManagementCoreV2 -> Swagger UI can be accessed using http://localhost:8091/swagger-ui.html

# Personal Note

Here is a microservice that I have created related to Take Home Test which is sent via email.

In this microservice, there is still much that can be improved, starting from security, auditing, and in terms of ticket transactions, for example with Camunda Workflow so that every transition from each ticket can be clearer, configurable, and more structured.

# Tech Stack

`Spring Boot`,`Liquibase`, `PostgreSql`, `Mapstruc`, `Eureka`,`Querydsl`,`Swagger Open API`.
