## Practical (included writing code or clearly code-oriented)

### Java – Core & Concurrency & Algorithms
- Create a **List** and add 5 items; define an **ArrayList** and print each number.
- Write how to **create a new thread** in Java; write a **thread method**; use **Thread** and **Runnable**; improve concurrency with `join`.
- **Make a HashMap thread-safe**; code handling of threads with a **ConcurrentHashMap**.
- **Java Stream API** tasks:
  - Iterate through a `HashMap` and return key/value pairs.
  - Get the keys from `HashMap<Key, List<Value>>`.
  - Given an array/list of integers, **find even numbers** using streams.
  - Filter evens and return as a list.
- **Coding challenges / algorithms**:
  - Given a set/list of numbers, **find non-repetitive numbers**.
  - **Sum of unique numbers** (e.g., `[1,2,3,4,5,5] → 10`, `[9,15,12,9,10,15,9] → 22`, `[1,2,1,2] → 0`).
  - **isPalindrome** coding question.
  - Create a list of strings, split each string into two parts, and add to a **HashMap**.
- **try / catch / finally**: write code and explain execution order.
- **Generics**: explain and demonstrate with code.

### Spring Boot / REST / Microservices
- Write a **REST controller** with a `POST` request in Spring.
- Write **mapping methods** in a Spring Boot controller: `@GetMapping`, `@PostMapping`, `@PutMapping` (with examples).
- Write a **REST controller + GET mapping** for a given endpoint.
- Return a **200 OK response** from a REST controller.
- Create a **REST method** to **save Employee details** to a database (include necessary annotations).
- Create **Employee** and **Contact** entities with a **one-to-many** relationship (JPA annotations).
- **Handle exceptions globally** using `@ControllerAdvice` and `@ExceptionHandler`; write a **custom exception**.
- Show the **entry point** of a Spring Boot app (`@SpringBootApplication`, `main` method).
- **Process 1000 requests with 10 threads** in Spring Boot (thread pool / executor example).
- (MVC) Demonstrate how you structure **Model–View–Controller** (e.g., entities, repositories, services, controllers).
- **CORS / Backend–Frontend connectivity**: configure allowed origins/headers/methods in Spring Boot (e.g., `CorsConfiguration`, `addCorsMappings`, or `@CrossOrigin`).
- **Use of @ControllerAdvice**: practical usage patterns (validation errors, global exception mapping).
- **Create a Spring Boot Microservice**:
  - Endpoint to **get Loan by id**.
  - Endpoint to **save Loan to DB** (repository/service).
- **API ingestion & persistence** (microservices scenario):
  - Create an API to **digest incoming information and save it**.
  - Create a **temporary (staging) table** to hold data received via a save endpoint.
  - **Specify classes & methods** you’d implement (DTOs, entities, mappers, repositories, services, controllers).
  - **Secure the endpoint** in practice (e.g., Spring Security with JWT/OAuth2, roles, method security).
  - Build an API that acts as a **middleware** between two applications; discuss **validation**, **schema mapping**, **idempotency**, **retries**, and **observability**.
  - **Service-to-service communication**: implement calls from one microservice to another (e.g., `WebClient`, Feign client, RestTemplate, messaging with Kafka/RabbitMQ); discuss **circuit breakers**, **timeouts**, **retries**, and **bulkheads**.

### SQL
- Write a query to **find the highest salary within a specific department**.

### Linux / CLI
- Write a **grep** command.

---

## Theoretical (Q&A, explanations, concepts)

### HTTP / REST
- Difference between **GET** and **POST**.
- **All HTTP methods** (GET, POST, PUT, PATCH, DELETE, etc.).
- Difference between **PUT** and **POST**.
- If a requested **id is not in the database**, what response is sent back? Why is **404** appropriate?
- Difference between **401** and **403**.
- Difference between **401** and **404**.
- How do you **connect a frontend** to a RESTful backend (high-level flow: fetch/axios, base URLs, environments).

### Spring / Spring Boot
- What is **dependency injection** and **how** is it done in Spring? (e.g., constructor injection, `@Autowired`).
- What is **@Autowired** used for?
- What is **MVC** (Model–View–Controller)?
- Where do you use **@Repository** and **@Service**?
- List common **class-level** and **method-level** **Spring annotations**.
- **Spring Batch**: how to **divide a job into chunks**?
- **Spring Security**: how does it work (filters, authentication/authorization, contexts)?
- **@ControllerAdvice vs @RestController** (roles/responsibilities at a high level).

### Java – Core Concepts
- **OOP** principles (encapsulation, inheritance, polymorphism, abstraction).
- Why/when would you use a **HashMap** in multithreading (and its pitfalls)?
- **Java 8 features**: Lambdas, `Optional`, Date/Time API, streams.
- **Generics**: explain concept and usage.

### Databases
- Difference between **SQL** and **NoSQL** (with examples).
- How to **connect** to SQL and NoSQL databases (drivers, configuration, ORMs).
- **Hibernate/JPA** basics: creating entities, columns, and writing a **1:many relationship** between two entities.

### Microservices / Architecture / DevOps
- **Microservices** experience (boundaries, decomposition).
- **12-Factor App** principles for microservices.
- **CI/CD**: goals, pipelines, integration, delivery/deployment, automation.
- Microservice-related tech/pattern (e.g., **Zuul**, **Zookeeper**, **Zipkin**).
- **Operational support**: steps you’d take if a **feature broke** (triage, logs, rollback, comms, fix, postmortem).

### Cloud / Tools / Frontend
- **AWS**: list common services.
- **Jira** experience (Agile workflows).
- **Kubernetes**: **Liveness** vs **Readiness** probes.
- **Docker**: components of a **Dockerfile**.
- **Angular**:
  - List some **directives**.
  - What are **components**?
  - What does the **@Component annotation** do?
  - What is **two-way data binding**?
  - What is a `*.spec.ts` file (unit test specification).

### Personal
- **Tell me about yourself.**