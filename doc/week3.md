# Learning Java – Week 3

Week 3 – Testing & New functionalities for Indie

Workload: ~XXh

## Testing

This week was dedicated to quality assurance and mastering the art of testing through the course: [Testez votre code Java pour réaliser des applications de qualité](https://openclassrooms.com/fr/courses/7159806-testez-votre-code-java-pour-realiser-des-applications-de-qualite).

Even though I already had strong foundations in testing from my JavaScript background, this course allowed me to go much deeper. I was able to refine my testing strategy, learning how to better design, structure, and organize tests within a complete Java ecosystem.

The learning journey focused on several key areas:
- **Unit Testing & Assertions**: Intensive use of **JUnit 5** and **AssertJ** to write readable and expressive tests.
- **Mocks & Doubles**: Mastering **Mockito** to isolate components and simulate complex behaviors.
- **Methodologies**: Practical application of **TDD** (Test Driven Development), **London TDD** (outside-in approach), and **BDD** (Behavior Driven Development).
- **Integration & E2E Testing**: Validating component interactions and full user journeys using **Selenium**.
- **Quality & Coverage**: Analyzing code coverage with **JaCoCo** and integrating continuous software quality via **SonarCloud/SonarQube**.

## "Indie" Evolution: Complexity & Scale

Building on the architectural foundations from Week 2, this week saw "Indie" evolve from a basic simulator to a more sophisticated fiscal engine. The focus shifted towards handling the nuances of French tax regulations and refining the internal structure.

**Key developments in Indie:**
- **Income Tax Engine**: Introduced a progressive calculation engine for income tax (IR). It now correctly applies the official tax brackets, calculating tax liabilities based on taxable income after deductions.
- **Refined Architecture**: Reorganized the `calculators` package with a clearer hierarchy of interfaces and classes. This separation of concerns ensures that flat-rate contributions (like micro-social) and progressive taxes are handled by specialized components.
- **Enhanced Simulation Options**: The simulator now offers a comparative view between two main fiscal paths:
    - **Flat Tax Option** (*Prélèvement Forfaitaire Libératoire*): A fixed percentage based on turnover.
    - **Standard IR Calculation**: Progressive tax based on the actual tax scale, accounting for activity-specific deductions.
- **Fiscal Logic**: Integrated deduction rules (e.g., standard 34%, 50%, or 71% abatement depending on the activity) to accurately determine the taxable base before applying the IR scale.
- **Quality & Coverage**:
    - **Continuous Integration**: Using **GitHub Actions** to automate the build and test process.
    - **Code Coverage**: Implemented **JaCoCo** to track code coverage and identify areas for improvement.
    - **SonarCloud/SonarQube**: Integrated SonarCloud to analyze code quality and identify potential issues.

## Projects

- [oc_project_4-testing](../oc_project_4-testing/README.md) – Practical application of unit and integration testing concepts on a batch calculator.
- [indie](../indie/README.md) – Now featuring an advanced tax calculation engine with progressive brackets.
