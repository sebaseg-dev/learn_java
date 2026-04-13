# Learning Java – Week 4

Week 4 – The Spring Ecosystem & Architectural Refinement

Workload: ~10h

## Create a Java Application with Spring Boot

This week was marked by a deep dive into the Spring ecosystem through the course: [Créez une application Java avec Spring Boot](https://openclassrooms.com/fr/courses/6900101-creez-une-application-java-avec-spring-boot).

After spending several weeks mastering Java's core concepts and manual dependency management, discovering Spring Boot felt like unlocking a new level of productivity. It simplifies development by handling most of the "plumbing" (configuration, server setup, dependency management) through its powerful "Starters" and "Auto-configuration".

**Key Takeaways from the course:**
- **Inversion of Control (IoC) & Dependency Injection**: Understanding how Spring manages object lifecycles and dependencies to ensure loosely coupled code.
- **Spring Initializr & Starters**: Quickly bootstrapping projects with predefined dependencies (Web, JPA, Test, etc.).
- **RESTful APIs**: Building robust endpoints with `@RestController`, `@GetMapping`, and `@PostMapping`.
- **Thymeleaf & Spring Web**: Creating dynamic web applications using server-side rendering.
- **Spring Boot Test**: Integrating unit and integration tests seamlessly with `@SpringBootTest` and `MockMvc`.
- **Deployment**: Packaging applications as executable JARs, ready for production.

This course provided the perfect bridge between pure Java logic and modern, enterprise-ready application development.

## Use Spring Data to Query a Database

To complement the web development part, I explored data persistence through the course: [Utilisez Spring Data pour interagir avec vos bases de données](https://openclassrooms.com/fr/courses/6982461-utilisez-spring-data-pour-interagir-avec-vos-bases-de-donnees).

The shift from manual SQL queries to Spring Data JPA significantly improved how I handle data. By using an Object-Relational Mapping (ORM) approach, the database becomes an extension of the Java code rather than a separate, disconnected layer.

**Key Takeaways from the course:**
- **JPA & Hibernate**: Mapping Java classes to database tables using annotations (`@Entity`, `@Id`, `@Table`). 
- **The Repository Pattern**: Using JpaRepository to perform CRUD operations (Create, Read, Update, Delete) without writing boilerplate SQL. 
- **Relationship Management**: Modeling data with `@OneToMany`, `@ManyToOne`, and `@ManyToMany` (both uni- and bidirectional). 
- **Custom Queries**: Implementing specific business logic using **Derived Queries** (method naming convention) and **JPQL** with the `@Query` annotation for more complex needs. 
- **Environment Setup**: Configuring the application.properties to connect the Spring Boot application to a live database.

## "Indie" Evolution: Clean Architecture & Unit Testing

Following the quality-first approach from Week 3, "Indie" underwent a significant architectural refactoring this week. The goal was to move from a flat structure to a more modular one, preparing for potential future integration with frameworks like Spring.

**Key developments in Indie:**
- **Separation of Concerns (SOC)**: Introduced a `SimulationService` to encapsulate all calculation logic. This allows the `MainController` to focus solely on user interactions and state management, delegating the heavy lifting to specialized services.
- **Enhanced Dependency Injection**: Refined the manual DI pattern. The `MainController` no longer requires direct knowledge of individual calculators (Tax, Social, Training, etc.), but only interacts with the `SimulationService`.
- **Robust Unit Testing**: Implemented a comprehensive test suite for the `MainController` using **JUnit 5** and **Mockito**.
    - **Behavior Verification**: Used `InOrder` verification to ensure the application follows the correct sequence of prompts and displays.
    - **Edge Case Handling**: Added parameterized tests to verify input validation for activities and turnovers.
    - **Error Management**: Improved how the application handles `CalculationException` and unexpected errors, ensuring a graceful exit or retry.
- **State Machine Refinement**: Cleaned up the main loop logic to improve readability and maintainability.

## Projects

- [oc_project_5-Spring_Boot](../oc_project_5-Spring_Boot) – Collection of three sub-projects (Hello World, API, and WebApp) demonstrating the power of Spring Boot.
- [oc_project_6-Spring_Data](../oc_project_6-Spring_Data)
- [indie](../indie/README.md) – Now features a clean service layer and comprehensive controller testing.
