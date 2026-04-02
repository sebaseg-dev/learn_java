package fr.sebaseg.testing.domain.model;

public enum CalculationType {
    ADDITION,
    MULTIPLICATION,
    DIVISION,
    SUBTRACTION,
    CONVERSION;

    public static CalculationType fromSymbol(String operation) {
        return switch (operation) {
            case "+" -> ADDITION;
            case "-" -> SUBTRACTION;
            case "/" -> DIVISION;
            case "*" -> MULTIPLICATION;
            case "x" -> MULTIPLICATION;
            default -> throw new UnsupportedOperationException("Not implemented yet");
        };
    }
}
