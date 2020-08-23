# rest-messaging-db

This is 3 Application that interact each other with different way of communication to simulate very simple microservice. 
* We have REST API with method GET and POST which sending sample Product data.
* We have Database (MySQL) with INSERT and QUERY 
* We have Messaging (RabbitMQ) complete with PUBLISH and CONSUME

## Sequence Diagram
![Rest API and Messaging flow](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/mirzaakhena/rest-messaging-db/master/diagram.wsd)

## Demo Apps
https://www.youtube.com/embed/yaLzOAycYhM


## Frontend Service
Since a backend server apps does not have "physical button" like a user interface, so i use a simple API to trigger another API.

This Frontend service only used for simplify the testing process by triggering other 2 API service in Producer and Consumer service. For triggering it you can use browser or curl or postman.

This service expose 2 API
* *GET* `http://localhost:8080/send-data`. It will call *POST* `http://localhost:8081/products` to send product to Producer Service
* *GET* `http://localhost:8080/get-data`. It will call *GET* `http://localhost:8082/products` to get product from Consumer Service

Currently run on port *8080*. To change the port you can refer to `frontend/src/main/resources/application.properties`

run it by
```
$ cd frontend/
$ mvn spring-boot:run
```


## Producer Service
In this Service, we will see how to sending message event to message broker (RabbitMQ). 

> Before runnning this service, make sure you already run the RabbitMQ. If you have a docker, you can just run `docker-compose up` from `docker/` directory

This Service have 2 API 
* *POST* `http://localhost:8081/products` This REST API will be called by Frontend Service to publish data product to the message broker 
* *GET* `http://localhost:8081/hello` This api only for demonstrate sending different event to the Consumer Service. It will only send simple "hello" message. This API can directly called via browser / curl / postman

Currently run on port *8081*. To change the port you can refer to `producer/src/main/resources/application.properties`

run it by
```
$ cd producer/
$ mvn spring-boot:run
```


## Consumer Service
This service show how to consume a message from messagebroker (RabbitMQ). All the messagebroker configuration is defined in `consumer/com/mirzaakhena/consumer/config/RabbitConfig.java`. From the config, you can see and learn how to setup 1 exchange, 2 different queue, and binding all together to work with this RabbitMQ message broker.

This service has 1 API that will called by Frontend Service
* *GET* `http://localhost:8082/products` is a REST API to get (read/query) product data from database

This service has 2 subscribed event
* `product_event`. This event will store (save/insert) product data to database
* `hello_event`. This event will trigger outputing hello message to console.

Currently run on port *8082*. To change the port you can refer to `consumer/src/main/resources/application.properties`. From the config, you can see and learn about how to setup config to working with MySQL database.

> To run this service you have to make sure your MySQL is running. Otherwise you will fail to run it. No need to setup any database or table. Spring boot will automatically create it for you. Just be aware about the database user and password.

Hello event is for demonstrating the ability of consumer to listen multiple event, since we already have a product event. 

run it by
```
$ cd consumer/
$ mvn spring-boot:run
```

