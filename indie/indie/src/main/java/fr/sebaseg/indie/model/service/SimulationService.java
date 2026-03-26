package fr.sebaseg.indie.model.service;

import fr.sebaseg.indie.model.calculators.MicroSocialCalculator;
import fr.sebaseg.indie.model.calculators.MicroTaxCalculator;
import fr.sebaseg.indie.model.calculators.ProfessionalTrainingContributionCalculator;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;

import java.math.BigDecimal;

public class SimulationService {
    public final MicroSocialCalculator socialCalculator;
    public final MicroTaxCalculator microTaxCalculator;
    public final ProfessionalTrainingContributionCalculator trainingContributionCalculator;

    public SimulationService(
            MicroSocialCalculator socialCalculator,
            MicroTaxCalculator microTaxCalculator,
            ProfessionalTrainingContributionCalculator trainingContributionCalculator
    ) {
        this.socialCalculator = socialCalculator;
        this.microTaxCalculator = microTaxCalculator;
        this.trainingContributionCalculator = trainingContributionCalculator;
    }

    public SimulationResult launchSimulation(EntrepreneurProfile profile) {
        BigDecimal turnover = profile.getTurnover();
        BusinessActivity activity = profile.getActivity();

        BigDecimal socialContribution = socialCalculator.calculate(turnover, activity);
        BigDecimal trainingContribution = trainingContributionCalculator.calculate(turnover, activity);
        BigDecimal taxWithholding = microTaxCalculator.calculateTaxWithholding(turnover, activity);

        return new SimulationResult(turnover, socialContribution, trainingContribution, taxWithholding);
    }
}
