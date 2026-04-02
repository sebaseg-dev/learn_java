# Indie - French Freelance Tax & Social Contribution Simulator

## Purpose

As a former finance manager turned developer, I have extensive experience navigating complex tax regulations. This project serves as a bridge between my professional background and my journey to mastering Java as a core language in my technical stack.

`indie` is a simple, open, and free CLI tool designed to help independent professionals in France (specifically "Micro-Entrepreneurs") understand the financial consequences of their choices. It calculates social contributions, income tax withholding, and training contributions based on their specific legal and tax regime.

## Key Learning Objectives

This project demonstrates my commitment to professional Java development practices:
- **Clean Code & SOLID Principles**: Maintaining a clear separation of concerns.
- **Design Patterns**: Implementation of proven architectural and behavioral patterns.
- **Modern Java Features**: Leveraging Enums, Streams (where applicable), and robust `BigDecimal` arithmetic for financial precision.
- **Dependency Management**: Utilizing Maven for building and managing external libraries (like Jackson for JSON parsing).

## Architecture & Design Patterns

The project follows a modular architecture to ensure maintainability and extensibility, applying several advanced patterns to handle the complexity of French tax laws.

### 1. MVC Pattern (Model-View-Controller)
The application is structured into three distinct layers:
- **Model**: Contains the business logic, data structures (`EntrepreneurProfile`, `BusinessActivity`), and the core calculation engines.
- **View**: A decoupled interface (`ViewInterface`) currently implemented as a `CommandLineView`, allowing for future UI expansions.
- **Controller**: The `MainController` orchestrates the flow, handling user input via the View and invoking calculations in the Model.

### 2. Specialized Calculation Engines
The architecture separates flat-rate contributions from progressive tax calculations:
- **Strategy Pattern (`FlatTaxCalculator`)**: Used for social contributions, professional training, and tax withholding. Different strategies (e.g., `MicroSocialCalculator`) implement this interface.
- **Progressive Tax Engine (`RevenueTaxCalculator`)**: A specialized engine that implements the official French progressive income tax (IR) scale, including dynamic threshold management and activity-specific deductions (34%, 50%, 71%).

### 3. Dependency Injection
Objects are composed rather than tightly coupled. The `MainController` and `SimulationService` receive their required calculators and providers through their constructors. This promotes testability and allows for easy swapping of components.

### 4. Data-Driven Configuration
Tax rates and social contribution percentages are not hardcoded. They are stored in a `rates.json` file and loaded via a `JsonRatesProvider`. This separation of data from logic allows the application to be updated for new fiscal years without modifying the source code.

## Technical Highlights & Best Practices

- **Financial Precision**: All monetary calculations use `java.math.BigDecimal` to avoid rounding errors.
- **Robust Type System**: Extensive use of Enums (`BusinessActivity`, `SocialCategory`) to ensure type safety and represent complex legal statuses.
- **Quality Assurance**: 
    - **Unit Testing**: Leveraging **JUnit 5** and **AssertJ** for expressive and documented business logic verification.
    - **Isolation**: Use of **Mockito** (where applicable) to isolate components and test specific behaviors.
    - **Clean Code**: Strict adherence to SOLID principles and DRY to maintain a professional-grade codebase.
- **Advanced Fiscal Logic**: Implementation of comparative simulation between the "Flat Tax" option (*Prélèvement Forfaitaire*) and the standard progressive tax calculation.

## Setting Up the Project

### Prerequisites
- **JDK 17** or higher
- **Maven 3.8+**

### Installation & Run

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd indie/indie
   ```

2. **Build the project**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn exec:java -Dexec.mainClass="fr.sebaseg.App"
   ```

## Code Base Structure

```text
src/main/java/fr/sebaseg/indie/
├── controller/       # Application flow orchestration
├── model/
│   ├── calculators/  # Tax & Social contribution engines (Strategy Pattern)
│   ├── config/       # JSON configuration & Rates providers
│   ├── data/         # Domain entities (Profile, Activity, Revenue)
│   └── service/      # Higher-level simulation logic & results
└── view/             # UI interfaces and CLI implementation
```