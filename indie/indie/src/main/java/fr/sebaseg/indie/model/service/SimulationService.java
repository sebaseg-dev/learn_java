package fr.sebaseg.indie.model.service;

import fr.sebaseg.indie.model.calculators.MicroSocialCalculator;
import fr.sebaseg.indie.model.calculators.MicroTaxCalculator;
import fr.sebaseg.indie.model.calculators.ProfessionalTrainingContributionCalculator;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;

import java.math.BigDecimal;

public class SimulationService {
    public final MicroSocialCalculator socialCalculator = new MicroSocialCalculator();
    public final MicroTaxCalculator taxCalculator = new MicroTaxCalculator();
    public final ProfessionalTrainingContributionCalculator trainingContributionCalculator = new ProfessionalTrainingContributionCalculator();

    public SimulationResult launchSimulation(EntrepreneurProfile profile) {
        BigDecimal turnover = profile.getTurnover();
        BusinessActivity activity = profile.getActivity();

        BigDecimal socialContribution = socialCalculator.calculate(turnover, activity);
        BigDecimal trainingContribution = trainingContributionCalculator.calculate(turnover, activity);
        BigDecimal taxWithholding = taxCalculator.calculateTaxWithholding(turnover, activity);

        return new SimulationResult(turnover, socialContribution, trainingContribution, taxWithholding);
    }
}
