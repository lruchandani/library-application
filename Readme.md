#Library Application

This application employs multiple spring boot apps  to showcase the microservice architecture patterns such as  
* service discovery
* Config management 
* Client and server side load balancing 
* event driven architecture
* API gateway

The application contains following services 
* [book-service](book-service)  
Manage books - create,update, search 
* [config-service](config-service)  
Centralized configuration based by files on the classpath 
* [user-service](user-service)  
User management
* [subscription-service](subscription-service)  
Manage user subscriptions such as - issue, return books
* [notification-service](notification-service)  
Event driven service for sending notifications on actions
* [discover-server](discovery-server)  
Discovery service based on Eureka.
* [zuul-service](zuul-service)
API gateway to provide a single entry point to the application.  

The services uses maven docker plugin and it  been attached with the maven phases (install and deploy).  
* build docker images  
```java
mvn clean install 
```
* build and push docker images
```java
mvn clean deploy
```
It docker and docker compose is installed  then  to bring up entire applications , use
```java
docker-compose up
```

 