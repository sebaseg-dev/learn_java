package fr.sebaseg.testing.service;

import java.util.List;
import java.util.stream.Stream;

import fr.sebaseg.testing.domain.model.CalculationModel;

public interface BatchCalculatorService {
    List<CalculationModel> batchCalculate(Stream<String> operations);
}