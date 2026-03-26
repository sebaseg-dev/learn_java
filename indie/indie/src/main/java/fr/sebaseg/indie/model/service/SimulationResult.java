package fr.sebaseg.indie.model.service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public record SimulationResult(
        BigDecimal turnover,
        BigDecimal socialContribution,
        BigDecimal professionalTrainingContribution,
        BigDecimal taxDeduction
) {

    public Map<String, BigDecimal> getResults(){
        Map<String, BigDecimal> results = new LinkedHashMap<>();
        results.put("Social Contribution", socialContribution);
        results.put("Professional Training Contribution", professionalTrainingContribution);
        results.put("Tax Deduction", taxDeduction);
        return results;
    }
}
