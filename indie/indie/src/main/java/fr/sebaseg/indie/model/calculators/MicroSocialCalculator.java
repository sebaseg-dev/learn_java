package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class MicroSocialCalculator {
    public BigDecimal getDeductionRate(BusinessActivity activity) {
        return switch (activity.getSocialCategory()) {
            case SALES -> new BigDecimal("0.123");
            case LISTED_RENTAL -> new BigDecimal("0.06");
            case OTHER_BIC -> new BigDecimal("0.212");
            case UNREGISTERED_LIBERAL -> new BigDecimal("0.256");
            case REGISTERED_LIBERAL -> new BigDecimal("0.232");
            default -> throw new IllegalArgumentException("MicroSocialCalculator => Catégorie micro sociale inconnue : " + activity.getSocialCategory());
        };
    }

    public BigDecimal calculate(BigDecimal turnover, BusinessActivity activity) {
        return turnover.multiply(getDeductionRate(activity));
    }
}
