A sample Spring boot application to test REST API for running CRUD operations on an Employee database.

Components:
- Maven
- Tomcat
- MySQL DB
- Postman client

Features:
- MVC Pattern showcasing the separation of code implementation and data logic from client implementation 
- Spring Boot with Hibernate ORM to seamlessly run SQL statements and interact with the DB using Java objects.                                                                                                                                                                                                                  
- Spring AOP to allow the separation of cross-cutting concerns (Exceptions in this case).
- Spring Actuator to expose the health and monitoring endpoints(metrics) of the application.
    - Also includes implementation of custom metrics.