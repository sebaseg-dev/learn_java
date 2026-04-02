package fr.sebaseg.testing.service;

import fr.sebaseg.testing.domain.Calculator;
import fr.sebaseg.testing.domain.model.CalculationModel;
import fr.sebaseg.testing.domain.model.CalculationType;

public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    private SolutionFormatter   solutionFormatter;

    public CalculatorServiceImpl(Calculator calculator, SolutionFormatter solutionFormatter) {
        this.calculator = calculator;
        this.solutionFormatter = solutionFormatter;
    }

    @Override
    public CalculationModel calculate(CalculationModel calculationModel) {
        final CalculationType type = calculationModel.getType();

        Integer response = switch (type) {
            case ADDITION -> calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case SUBTRACTION -> calculator.sub(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case MULTIPLICATION ->
                    calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case DIVISION -> {
                try {
                    calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                yield calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            }
            default -> throw new UnsupportedOperationException("Unsupported calculations");
        };

        calculationModel.setSolution(response);
        calculationModel.setFormattedSolution(solutionFormatter.format(response));
        return calculationModel;
    }

}