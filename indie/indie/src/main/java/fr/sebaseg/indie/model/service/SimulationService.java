package fr.sebaseg.indie.model.service;

import fr.sebaseg.indie.model.calculators.CalculatorInterface;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;

import java.math.BigDecimal;

public class SimulationService {
    private final CalculatorInterface taxCalculator;
    private final CalculatorInterface socialContributionCalculator;
    private final CalculatorInterface trainingContributionCalculator;

    public SimulationService(
            CalculatorInterface taxCalculator,
            CalculatorInterface socialContributionCalculator,
            CalculatorInterface trainingContributionCalculator
    ) {
        this.socialContributionCalculator = socialContributionCalculator;
        this.taxCalculator = taxCalculator;
        this.trainingContributionCalculator = trainingContributionCalculator;
    }

    public SimulationResult launchSimulation(EntrepreneurProfile profile) {
        BigDecimal turnover = profile.getTurnover();
        BusinessActivity activity = profile.getActivity();

        BigDecimal socialContribution = socialContributionCalculator.calculate(turnover, activity);
        BigDecimal trainingContribution = trainingContributionCalculator.calculate(turnover, activity);
        BigDecimal taxWithholding = taxCalculator.calculate(turnover, activity);

        BigDecimal netIncome = turnover.subtract(taxWithholding).subtract(socialContribution).subtract(trainingContribution);

        return new SimulationResult(turnover, taxWithholding, socialContribution, trainingContribution, netIncome);
    }
}
