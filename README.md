# Spring Boot CRUD Tutorial - Product Management System

A Spring Boot application for managing products, customers, and food items with expiration tracking. Built with Spring MVC, JPA, and Thymeleaf.

## 🚀 Features

- **Product Management**: CRUD operations for products with SKU, description, category, and pricing
- **Customer Management**: Manage customers with embedded address information
- **Food Item Tracking**: Product expiration date monitoring with expired items dashboard
- **User Authentication**: Basic Spring Security implementation
- **Web Interface**: Thymeleaf-based UI with RESTful API endpoints

## 🛠️ Tech Stack

- **Framework**: Spring Boot 2.4.0
- **Language**: Java 17
- **Database**: H2 (in-memory) / SQLite
- **ORM**: Hibernate JPA
- **Security**: Spring Security
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven

## ⚠️ Compatibility Notice

This project uses:

- **Spring Boot 2.4.0**
- **Java 17**
- **Maven 3.8+**

> ⚠️ **Do not use Java 21 or Spring Boot 3+ with this version**.  
> It may lead to compatibility issues (e.g., deprecated APIs, failing tests, unsupported plugin goals).

> ✅ If you're using Java 21, either:
>
> - Downgrade your Java version to 17, or
> - Upgrade Spring Boot and dependencies throughout the project (requires refactoring and test fixes).

## 🧪 Known Test Issue

The file `CrudTutorialApplicationTests.java` is **disabled** due to class compatibility issues caused by version mismatches.  
If you'd like to enable tests again, ensure Spring Boot and your JDK versions are compatible and refactor accordingly.

If you face build errors:

```bash
# Skip tests during build
mvn clean install -DskipTests

## 📁 Project Structure

```

src/main/java/com/example/CRUDTutorial/
├── Controller/ # REST controllers
├── Model/ # JPA entities
├── Repository/ # Data access layer
└── Service/ # Business logic

````

## 🗄️ Key Entities

- **Product**: Basic product information (SKU, description, category, price)
- **Customer**: Business details with embedded address
- **FoodItem**: Products with expiration dates
- **User**: Authentication and authorization

## 🚀 Getting Started

### Prerequisites
- Java 17
- Maven  3.8+ (required for Java 17 support)

### Quick Start
```bash
git clone https://github.com/saadamir1/spring-boot-product-management.git
cd spring-boot-product-management
mvn spring-boot:run
````

Access at: `http://localhost:8080`

## 📡 API Endpoints

### Products

- `GET /products/` - List products
- `POST /products/Save` - Create product
- `GET /products/findByID/{id}` - Get product (JSON)
- `GET /products/expiredProducts` - View expired items

### Customers

- `GET /customers/` - List customers
- `POST /customers/saveCustomer` - Create customer
- `GET /customers/findCustomerByID/{id}` - Get customer (JSON)

## 🎯 Key Features

- **Embedded Address**: Uses `@Embeddable` for address components
- **Expiration Tracking**: Custom repository methods for expired food items
- **Dual Interface**: Supports both web UI and JSON responses
- **Security**: User authentication with role-based access

## 🛡️ Security

Basic Spring Security setup with user authentication, role management, and custom login pages.

## 🚀 Deployment

**Development**: `mvn spring-boot:run`
**Production**: `mvn clean package && java -jar target/CRUDTutorial-0.0.1-SNAPSHOT.jar`

## 📞 Contact

Saad Amir - [saadamir070@gmail.com]
Project Link: [https://github.com/saadamir1/spring-boot-product-management]

---

_A learning project demonstrating Spring Boot CRUD operations, JPA relationships, and web development best practices._
