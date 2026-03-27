# Learning Java – Week 1

Week 1 – Introduction to Java

Workload: ~20h

## Transitioning to Java

I started with the core Java programming course: [Apprenez à programmer en Java](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java).

Coming from a background in JavaScript (MVC/OOP then React/Functional) and PHP (Symfony/MVC), I found the transition to Java very natural. The core concepts of Object-Oriented Programming (OOP) and Type Safety are familiar, but Java's strictness and "everything is an object" philosophy bring a welcome level of rigor.

Key technical takeaways:
- **Strong Typing & Interfaces**: Understanding Java's implementation of interfaces and inheritance was straightforward given my experience with PHP's type system.
- **Dependency Injection**: My familiarity with Symfony's DI container made it easy to grasp how to structure a Java application using constructor injection for better testability and decoupling.

## Tooling & Project Management

I am intentional about my development environment. I am using the [Zed editor](https://zed.dev/) instead of a heavy IDE like IntelliJ IDEA (even though I own a license).

**Why Zed?**
- **Speed & Focus**: It’s fast and minimalist, preventing "IDE-dependency."
- **Manual Mastery**: By avoiding bloated UI shortcuts and aggressive AI code generation, I am forced to understand the underlying build processes and syntax.

To manage the lifecycle, I completed the first part of the [Apache Maven course](https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven). Using Maven allows me to:
- Organize projects following industry standards.
- Manage external dependencies (like Jackson for JSON).
- Compile and package applications directly from the terminal or within Zed.

## Achievements

- **Maven Integration**: Successfully set up a multi-module style workflow for various learning exercises.
- **Dependency Management**: Learned to manage external libraries (like Jackson for JSON parsing) using the Maven lifecycle.
- **Java Fundamentals**: Mastered core concepts like strong typing, inheritance, and interfaces.

## Projects:

- [hello-world](../hello-world/README.md) – Simple Hello World console application.
- [oc_project_1-learn_java](../oc_project_1-learn_java/README.md) – Core Java exercises from OpenClassrooms.
- [oc_project_2-learn_maven](../oc_project_2-learn_maven/README.md) – Maven organization and packaging project.
