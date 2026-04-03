package fr.sebaseg.indie.model.service;

import fr.sebaseg.indie.model.calculators.FlatTaxCalculator;
import fr.sebaseg.indie.model.calculators.RevenueTaxCalculator;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;

import java.math.BigDecimal;

public class SimulationService {
    private final FlatTaxCalculator taxCalculator;
    private final FlatTaxCalculator socialContributionCalculator;
    private final FlatTaxCalculator trainingContributionCalculator;
    private final RevenueTaxCalculator revenueTaxCalculator;

    public SimulationService(
            FlatTaxCalculator taxCalculator,
            FlatTaxCalculator socialContributionCalculator,
            FlatTaxCalculator trainingContributionCalculator,
            RevenueTaxCalculator revenueTaxCalculator
    ) {
        this.socialContributionCalculator = socialContributionCalculator;
        this.taxCalculator = taxCalculator;
        this.trainingContributionCalculator = trainingContributionCalculator;
        this.revenueTaxCalculator = revenueTaxCalculator;
    }

    public SimulationResult launchSimulation(EntrepreneurProfile profile) {
        BigDecimal turnover = profile.getTurnover();
        BusinessActivity activity = profile.getActivity();

        BigDecimal socialContribution = socialContributionCalculator.calculate(turnover, activity);
        BigDecimal trainingContribution = trainingContributionCalculator.calculate(turnover, activity);
        BigDecimal taxWithholding = taxCalculator.calculate(turnover, activity);
        BigDecimal revenueTaxes = revenueTaxCalculator.calculate(turnover, activity);

        BigDecimal netIncomeAfterWithholdingTaxes = turnover.subtract(taxWithholding).subtract(socialContribution).subtract(trainingContribution);
        BigDecimal netIncomeAfterRevenueTaxes = turnover.subtract(revenueTaxes).subtract(socialContribution).subtract(trainingContribution);

        return new SimulationResult(turnover, taxWithholding, revenueTaxes, socialContribution, trainingContribution, netIncomeAfterWithholdingTaxes, netIncomeAfterRevenueTaxes);
    }
}
