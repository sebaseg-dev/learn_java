package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class ProfessionalTrainingContributionCalculator {

    public BigDecimal getRate(BusinessActivity activity) {
        return switch (activity.getProfessionalTrainingContribution()) {
            case SALES -> new BigDecimal("0.001");
            case ARTISAN -> new BigDecimal("0.003");
            case LIBERAL -> new BigDecimal("0.002");
            default -> throw new IllegalArgumentException("ProfessionalTrainingContributionCalculator => Catégorie de Contribution à la Formation Professionnelle inconnue : " + activity.getProfessionalTrainingContribution());
        };
    }

    public BigDecimal calculate(BigDecimal turnover, BusinessActivity activity) {
        return turnover.multiply(getRate(activity));
    }
}
