package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class MicroWithholdTaxCalculator implements CalculatorInterface {

    @Override
    public BigDecimal getRate(BusinessActivity activity) {
        return switch (activity.getTaxCategory()) {
            case BIC_SALES -> new BigDecimal("0.01");
            case BIC_SERVICES, BIC_LISTED_RENTAL, BIC_NON_LISTED_RENTAL -> new BigDecimal("0.017");
            case BNC -> new BigDecimal("0.022");
            default -> throw new IllegalArgumentException("MicroTaxCalculator => Catégorie micro fiscale inconnue : " + activity.getTaxCategory());
        };
    }

}
