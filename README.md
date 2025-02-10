# DeliciousFood Aplication

## **Technologies to Use**

- **Sping Boot**: For the backend.
- **Spring Data JPA**: For the persistence layer.
- **Lombok**: To reduce boilerplate code.
- **Spring Security**: For authentication and authorization.
- **JUnit & Mockito**: For unit testing.
- **Swagger**: For API documentation.

## **Project Structure**

### **Entities**

Mapping of database tables.

### **Repositories**

Spring Data JPA interfaces for database access.

### **Services**

Business logic.

### **Controllers**

REST API endpoints.

### **DTOs**

Data Transfer Objects.

### **Unit Tests**

Tests for services and controllers.

### **Prerequisites**

- Install Docker
- Install Maven
- Swagger

## **Run the application**

`mvn clean install`

`docker-compose build`

`docker-compose up`

Note: you can reach the application in POSTMAN in the next context:

`http://localhost:8085/api/<resource>`