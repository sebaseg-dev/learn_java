package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class ProfessionalTrainingContributionCalculator implements CalculatorInterface {

    @Override
    public BigDecimal getRate(BusinessActivity activity) {
        return switch (activity.getProfessionalTrainingContribution()) {
            case SALES -> new BigDecimal("0.001");
            case ARTISAN -> new BigDecimal("0.003");
            case LIBERAL -> new BigDecimal("0.002");
            default -> throw new CalculationException("Le calcul de la contribution à la formation professionnelle pour l'activité " + activity.name() + " n'est pas encore supporté.");
        };
    }

}
