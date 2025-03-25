# Category-Product CRUD API

A Spring Boot application that demonstrates CRUD operations for **Categories** and **Products** with a one-to-many relationship using RESTful APIs, JPA, Hibernate, MySQL, and server-side pagination.

---
# 🗂️ Maven Project Architecture

```
category-product-api_Crud/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── crud/
│   │   │           └── categoryproductapi/
│   │   │               ├── CategoryProductApiApplication.java   # Main Spring Boot class
│   │   │
│   │   │               ├── controller/
│   │   │               │   ├── CategoryController.java          # Category endpoints
│   │   │               │   └── ProductController.java           # Product endpoints
│   │   │
│   │   │               ├── entity/
│   │   │               │   ├── Category.java                    # Category entity
│   │   │               │   └── Product.java                     # Product entity
│   │   │
│   │   │               ├── repository/
│   │   │               │   ├── CategoryRepository.java          # JPA repository for Category
│   │   │               │   └── ProductRepository.java           # JPA repository for Product
│   │   │
│   │   │               └── service/
│   │   │                   ├── CategoryService.java             # Interface for category service
│   │   │                   └── ProductService.java              # Interface for product service
│   │
│   │   └── resources/
│   │       ├── application.properties                           # DB config, port, JPA settings
│   │       └── static/                                          # Static files (if any)
│   │
│   └── test/
│       └── java/                                                # Unit/Integration tests (optional)
│
├── pom.xml                                                     # Maven dependencies and build config
```
## 📦 Technologies Used

- Java 17
- Spring Boot 3.1.4
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation

---

## ⚙️ Setup & Run

### 1. Clone the Repository
```
---
git clone https://github.com/B766-p/Springboot_crud_operations_RestApi.git
cd category-product-api_Crud
```
### 2.⚙️ Configure Database
```
---
Update your database credentials in `src/main/resources/application.properties`:
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
```
🚀 Build and Run
```
---
Way 1: Using Maven Command
mvn spring-boot:run
Way 2:Using  execute the main() method from your CategoryProductApiApplication class present in com.crud.categoryproductapi:
SpringApplication.run(CategoryProductApiApplication.class, args);
Once started, the API will be accessible at:
📍 http://localhost:8051/(Defult port no 8080 but in my pc it was alocated to oracel-enterprise-database )
#For Setup:
In application.properties, add:
# Server Port (optional)
server.port=8051
If it is not free fallows the step:
Step 1:C:\Users\DELL>netstat -ano | findstr :8051
  TCP    0.0.0.0:8051           0.0.0.0:0              LISTENING       4616
  TCP    [::]:8051              [::]:0                 LISTENING       4616
Step 2:C:\Users\DELL>taskkill /PID 4616 /F
SUCCESS: The process with PID 4616 has been terminated.
```
📘 API Endpoints
```
---
## 🗂️ Category CRUD APIs

| Method | Endpoint                   | Description             |
|--------|----------------------------|-------------------------|
| GET    | /api/categories?page=0     | Get paginated categories|
| POST   | /api/categories            | Create a category       |
| GET    | /api/categories/{id}       | Get category by ID      |
| PUT    | /api/categories/{id}       | Update category by ID   |
| DELETE | /api/categories/{id}       | Delete category by ID   |

---

## 📦 Product CRUD APIs

| Method | Endpoint                   | Description                           |
|--------|----------------------------|---------------------------------------|
| GET    | /api/products?page=0       | Get paginated products                |
| POST   | /api/products              | Create a product                      |
| GET    | /api/products/{id}         | Get product by ID (with category)     |
| PUT    | /api/products/{id}         | Update product by ID                  |
| DELETE | /api/products/{id}         | Delete product by ID                  |
```
🔗 Category-Product Relationship
```
---
One Category can have many Products (One-to-Many).

Each Product belongs to one Category (Many-to-One).
```  
# 🧩 Annotation Reference (One-liner Explanations)
```
---
| Annotation                         | Description                                                                 |
|------------------------------------|-----------------------------------------------------------------------------|
| `@SpringBootApplication`           | Marks the main class as a Spring Boot application entry point.             |
| `@Entity`                          | Declares the class as a JPA entity mapped to a database table.             |
| `@Id`                              | Specifies the primary key of the entity.                                   |
| `@GeneratedValue`                  | Automatically generates values for the primary key.                        |
| `@OneToMany`                       | Defines a one-to-many relationship between entities.                       |
| `@ManyToOne`                       | Defines a many-to-one relationship between entities.                       |
| `@JoinColumn`                      | Specifies the foreign key column for the relationship.                     |
| `@JsonManagedReference`            | Prevents infinite recursion during JSON serialization (used on parent side).|
| `@JsonBackReference`               | Prevents infinite recursion during JSON serialization (used on child side).|
| `@JsonIgnore`                      | Ignores the field during JSON serialization.                               |
| `@RestController`                  | Declares the class as a RESTful controller.                                |
| `@RequestMapping`                  | Maps HTTP requests to handler methods or classes.                          |
| `@GetMapping`                      | Maps HTTP GET requests to handler methods.                                 |
| `@PostMapping`                     | Maps HTTP POST requests to handler methods.                                |
| `@PutMapping`                      | Maps HTTP PUT requests to handler methods.                                 |
| `@DeleteMapping`                   | Maps HTTP DELETE requests to handler methods.                              |
| `@PathVariable`                    | Binds a URI template variable to a method parameter.                       |
| `@RequestBody`                     | Maps the body of the HTTP request to a method parameter.                   |
| `@Autowired`                       | Automatically injects dependencies at runtime.                             |
| `@Data` (Lombok)                   | Generates getters, setters, toString, equals, and hashCode automatically.  |
| `@NoArgsConstructor` (Lombok)      | Generates a no-argument constructor.                                       |
| `@AllArgsConstructor` (Lombok)     | Generates a constructor with all fields as parameters.                     |
| `@Repository` (implicit in interfaces) | Indicates a Spring Data repository that interacts with the database (inferred from extending `JpaRepository`). |
| `@Service` *(if used elsewhere)*    | Marks a class as a service layer component in the business logic.          |
| `@ComponentScan` *(via `@SpringBootApplication`)* | Enables automatic discovery of components, services, and controllers.     |
| `@Configuration` *(via `@SpringBootApplication`)* | Indicates that a class declares one or more `@Bean` methods and can be processed by the Spring container. |
| `@EnableAutoConfiguration` *(via `@SpringBootApplication`)* | Tells Spring Boot to automatically configure your project based on the dependencies. |
| `@RequestParam`                     | Extracts query parameters from the request URL and binds them to method parameters. |
| `@Optional` *(Java Util)*           | Represents a container object which may or may not contain a non-null value. Used for safer null handling. |
| `@Table` *(optional in use with `@Entity`)* | Specifies the table name in the database (defaults to class name if not set). |
| `@RequestMapping("/api/categories")` | Maps all requests beginning with `/api/categories` to the controller class. |
| `@RequestMapping("/api/products")`   | Maps all requests beginning with `/api/products` to the controller class.   |
| `@GetMapping("/{id}")`               | Maps HTTP GET requests to a specific method with a path variable.           |
| `@PostMapping`                       | Maps HTTP POST requests to a method that handles entity creation.           |
| `@PutMapping("/{id}")`               | Maps HTTP PUT requests for updating an entity by ID.                        |
| `@DeleteMapping("/{id}")`            | Maps HTTP DELETE requests for deleting an entity by ID.                     |
| `@RestController`                    | Combines `@Controller` and `@ResponseBody` — makes the class ready for REST APIs. |
| `@Autowired`                         | Automatically injects required beans by type from the Spring container.     |
| `@PathVariable`                      | Binds a method parameter to a path variable in the URL.                     |
| `@RequestBody`                       | Binds the body of a request to a method parameter for POST/PUT methods.     |
```
