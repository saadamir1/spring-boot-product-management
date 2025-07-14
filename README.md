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
- **Language**: Java 21
- **Database**: H2 (in-memory) / SQLite
- **ORM**: Hibernate JPA
- **Security**: Spring Security
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven

## 📁 Project Structure

```
src/main/java/com/example/CRUDTutorial/
├── Controller/          # REST controllers
├── Model/              # JPA entities
├── Repository/         # Data access layer
└── Service/           # Business logic
```

## 🗄️ Key Entities

- **Product**: Basic product information (SKU, description, category, price)
- **Customer**: Business details with embedded address
- **FoodItem**: Products with expiration dates
- **User**: Authentication and authorization

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven  3.8+ (Recommended for Java 21 support)

### Quick Start
```bash
git clone https://github.com/saadamir1/spring-boot-product-management.git
cd spring-boot-product-management
mvn spring-boot:run
```

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

*A learning project demonstrating Spring Boot CRUD operations, JPA relationships, and web development best practices.*
