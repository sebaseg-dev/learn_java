package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class MicroSocialCalculator implements CalculatorInterface {

    @Override
    public BigDecimal getRate(BusinessActivity activity) {
        return switch (activity.getSocialCategory()) {
            case SALES -> new BigDecimal("0.123");
            case LISTED_RENTAL -> new BigDecimal("0.06");
            case OTHER_BIC -> new BigDecimal("0.212");
            case UNREGISTERED_LIBERAL -> new BigDecimal("0.256");
            case REGISTERED_LIBERAL -> new BigDecimal("0.232");
            default -> throw new CalculationException("Le calcul des cotisations sociales pour l'activité " + activity.name() + " n'est pas encore supporté.");
        };
    }

}
