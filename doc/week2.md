# Learning Java – Week 2

Week 2 – Architecture & Clean Code

Workload: ~25h

## Architecture & SOLID Principles

This week was focused on architectural maturity through the course: [Maintainable Java Code with MVC and SOLID](https://openclassrooms.com/fr/courses/6810956-ecrivez-du-code-java-maintenable-avec-mvc-et-solid).

I've integrated these principles into my workflow to ensure that "Indie" isn't just a functional tool, but a professional-grade codebase. Implementing a clean **MVC (Model-View-Controller)** architecture provides several key advantages:
- **Decoupling**: The business logic (Model) is entirely independent of the user interface (View). This allows me to swap the current CLI for a Web or Desktop interface without touching the core calculation engine.
- **Maintainability**: Following **SOLID** principles (especially Single Responsibility and Dependency Inversion) makes the code easier to test and extend. For instance, adding a new tax regime only requires adding a new "Strategy" class rather than modifying existing logic.

## Project: "Indie" (In Progress)

I have officially bootstrapped the `indie` project, applying the patterns learned this week. 

**Current state of development:**
- **Core Engine**: The `SimulationService` is operational, orchestrating calculations between social contributions, income tax, and training contributions.
- **Strategy Pattern**: Different tax rules are encapsulated in dedicated calculator classes, making the system highly flexible.
- **Data-Driven Configuration**: Integrated **Jackson** to load tax rates from an external `rates.json` file, ensuring the app can be updated for new fiscal years without code changes.
- **CLI View**: A functional command-line interface handles user profiles and turnover inputs.

## Projects

- [oc_project_3-MVC](../oc_project_3-MVC/README.md) – Mastering MVC and Strategy patterns with a card game.
- [indie](../indie/README.md) – The first functional draft of the freelance tax simulator.

## Achievements

- **MVC Implementation**: Structured `indie` with a strict separation of concerns.
- **Advanced Strategy Pattern**: Refined the calculation engine to handle complex French tax regulations using interfaces.
- **Financial Precision**: Implemented `BigDecimal` across all calculations to ensure professional-grade accuracy.
- **JSON Integration**: Successfully implemented externalized configuration for tax rates.