# Java Mastery Journey: From PHP/JS to Enterprise Java

This repository documents my transition to Java, focusing on professional standards, clean architecture, and the Spring ecosystem.

## 🚀 The Roadmap

My learning path is structured to leverage my existing experience in PHP (Symfony) and JavaScript (React) while mastering Java-specific patterns and tools.

- **[Week 0: Strategy & Context](./doc/week0.md)** – Why Java? Market analysis and curriculum design.
- **[Week 1: Foundations & Tooling](./doc/week1.md)** – Core Java, Maven, and transitioning from PHP/JS.
- **[Week 2: Clean Code & Architecture](./doc/week2.md)** – MVC, SOLID principles, and the birth of "Indie".
- **[Week 3 – Testing & New functionalities for Indie](./doc/week3.md)**
---

## 📈 Weekly Progress

### [Week 1 – Java Foundations & Build Automation](./doc/week1.md)
**Focus:** Mastering Java syntax, type safety, and the Maven build lifecycle.

**Key Achievements:**
- **Transitioned from PHP/Symfony**: Successfully mapped OOP and Dependency Injection concepts to Java.
- **IDE-Agnostic Workflow**: Chose the minimalist **Zed editor** to master the Java compiler and Maven CLI without IDE assistance.
- **Maven & Dependency Management**: Learned to structure projects and manage external libraries (Jackson) following industry standards.

**Courses Completed:**
- ✅ [Java Programming Foundations](https://openclassrooms.com/fr/courses/8383791-apprenez-a-programmer-en-java)
- ✅ [Build Automation with Apache Maven](https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven)

---

### [Week 2 – Architecture & Design Patterns](./doc/week2.md)
**Focus:** Clean Code, SOLID principles, and building a professional Proof of Concept.

**Key Achievements:**
- **Indie Project Bootstrapped**: Applied the **Strategy Pattern** for a flexible and extensible tax calculation engine.
- **MVC Implementation**: Structured the "Indie" simulator with a strict separation between CLI view, calculation models, and orchestration controllers.
- **SOLID Principles in Practice**: Leveraged Dependency Inversion and Single Responsibility to create a maintainable codebase.
- **Data-Driven Architecture**: Integrated Jackson for JSON configuration, separating business rules (tax rates) from code.

**Courses Completed:**
- ✅ [Maintainable Code with MVC & SOLID](https://openclassrooms.com/fr/courses/6810956-ecrivez-du-code-java-maintenable-avec-mvc-et-solid)
- ✅ [Testing & Quality Assurance](https://openclassrooms.com/fr/courses/6100311-testez-votre-code-java-pour-realiser-des-applications-de-qualite)

---

### [Week 3 – Testing & Advanced Tax Calculations](./doc/week3.md)
**Focus:** Mastering Java testing (JUnit, Mockito) and implementing complex fiscal logic in the tax engine.

**Key Achievements:**
- **Robust Test Strategy**: Deepened the Test Pyramid, JUnit 5, and AssertJ to build a verified and documented codebase.
- **Advanced Mocks**: Implemented Mockito for component isolation and complex behavior simulation.
- **Income Tax Engine**: Implemented a progressive IR calculation engine with official French tax brackets.
- **Fiscal Logic Refinement**: Integrated comparative simulation between Flat Tax and Progressive IR, accounting for activity-specific deductions.
- **Quality Assurance**: Ensured code coverage and adherence to industry standards by implementing **SonarQube** and its standard quality gates.

**Courses Completed:**
- ✅ [Testing for Quality Java Applications](https://openclassrooms.com/fr/courses/6100311-testez-votre-code-java-pour-realiser-des-applications-de-qualite)

---

## 🛠 Featured Project: [Indie](./indie/README.md)

`indie` is a French freelance tax & social contribution simulator. It serves as the primary laboratory for applying my learning:
- **Patterns**: Strategy, MVC, Dependency Injection.
- **Precision**: `BigDecimal` for financial accuracy.
- **Config**: JSON-based rate providers.

---
*Explore the [detailed curriculum](./doc/curriculum.md) for the full learning path.*