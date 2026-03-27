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

The project follows a modular architecture to ensure maintainability and extensibility.

### 1. MVC Pattern (Model-View-Controller)
The application is structured into three distinct layers:
- **Model**: Contains the business logic, data structures (`EntrepreneurProfile`, `BusinessActivity`), and the core calculation engine.
- **View**: A decoupled interface (`ViewInterface`) currently implemented as a `CommandLineView`, allowing for future UI expansions (Swing, Web, etc.).
- **Controller**: The `MainController` orchestrates the flow, handling user input via the View and invoking calculations in the Model.

### 2. Strategy Pattern
The calculation logic is abstracted through the `CalculatorInterface`. Different calculation strategies (e.g., `MicroSocialCalculator`, `MicroWithholdTaxCalculator`) implement this interface. This allows the simulation engine to remain agnostic of the specific tax rules being applied, facilitating easy updates when French tax laws change.

### 3. Dependency Injection
Objects are composed rather than tightly coupled. For instance, the `MainController` and `SimulationService` receive their required calculators through their constructors. This promotes testability and allows for easy swapping of components (e.g., using mock providers for testing).

### 4. Data-Driven Configuration
Tax rates and social contribution percentages are not hardcoded. They are stored in a `rates.json` file and loaded via a `JsonRatesProvider`. This separation of data from logic is a professional standard that makes the application easier to maintain across different fiscal years.

## Technical Highlights

- **Financial Precision**: All monetary calculations use `java.math.BigDecimal` to avoid the rounding errors inherent in `double` or `float`.
- **Robust Type System**: Extensive use of Enums (`BusinessActivity`, `SocialCategory`) to represent complex legal statuses, ensuring type safety and reducing runtime errors.
- **Error Handling**: Custom exceptions (`CalculationException`) and input validation loops ensure a smooth user experience.

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
│   ├── calculators/  # Calculation strategies (Social, Tax, Training)
│   ├── config/       # JSON configuration providers
│   ├── data/         # Core domain entities (Profile, Activity)
│   └── service/      # Higher-level simulation logic
└── view/             # UI interfaces and CLI implementation
```