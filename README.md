# DeliciousFood - Online Food Delivery System

## Project Description

**DeliciousFood** is an online platform for ordering food and managing deliveries. It is designed for three main actors:

- **Users**: Place food orders.
- **Restaurants**: Manage their menus and receive orders.
- **Delivery Men**: Handle order deliveries.

The system includes modules for:

- User, restaurant, and delivery man registration.
- Restaurant search by category.
- Order placement and tracking.
- Notifications for restaurants and delivery men.

## Technologies Used

- **Programming Language**: Java 17
- **Framework**: Spring Boot 3.1.0
- **Database**: H2 (development), MySQL/PostgreSQL (production)
- **API Documentation**: Swagger (SpringDoc OpenAPI)
- **Unit Testing**: JUnit 5, Mockito
- **Dependency Management**: Maven
- **Version Control**: Git

## Project Structure

The project follows a **hexagonal architecture** (ports and adapters) to separate business logic from infrastructure.
The structure is as follows:

## Installation and Execution

### Prerequisites

- Java 17
- Maven 3.8+
- Docker (optional, for containerized execution)

### Steps to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Cesarwth/DeliciousFood.git
   cd deliciousfood

2. **Build the Project:**
   ```bash
   mvn clean install

3. **Run the Application:**
   ```bash
   mvn spring-boot:run

4. **Access the API:**
   ```bash
   Swagger UI: http://localhost:8080/swagger-ui.html
   OpenAPI JSON: http://localhost:8080/v3/api-docs

5. **Run with Docker (optional):**

   Build the image:
   ```bash
   docker build -t deliciousfood .

6. Run the container:

    ```bash
    docker run -p 8080:8080 deliciousfood

### Usage Examples

#### Register a User

***Endpoint: POST /api/users***

**Request Body:**

   ```bash
    {
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123",
    "phoneNumber": "123456789",
    "address": "123 Main St",
    "role": "USER"
    }