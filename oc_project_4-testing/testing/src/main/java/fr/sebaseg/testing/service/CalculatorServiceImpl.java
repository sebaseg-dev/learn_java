package fr.sebaseg.testing.service;

import fr.sebaseg.testing.domain.Calculator;
import fr.sebaseg.testing.domain.model.CalculationModel;
import fr.sebaseg.testing.domain.model.CalculationType;

public class CalculatorServiceImpl implements CalculatorService {

    private final Calculator calculator;

    public CalculatorServiceImpl(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public CalculationModel calculate(CalculationModel calculationModel) {
        final CalculationType type = calculationModel.getType();

        Integer response = switch (type) {
            case ADDITION -> calculator.add(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case SUBTRACTION -> calculator.sub(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case MULTIPLICATION ->
                    calculator.multiply(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            case DIVISION -> calculator.divide(calculationModel.getLeftArgument(), calculationModel.getRightArgument());
            default -> throw new UnsupportedOperationException("Unsupported calculations");
        };

        calculationModel.setSolution(response);
        return calculationModel;
    }

}