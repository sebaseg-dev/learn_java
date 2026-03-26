package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class MicroTaxCalculator {
    private final BigDecimal MINIMUM_TAX_DEDUCTION = new BigDecimal("305");

    public BigDecimal getDeductionRate(BusinessActivity activity) {
        return switch (activity.getTaxCategory()) {
            case BIC_SALES -> new BigDecimal("0.71");
            case BIC_SERVICES, BIC_LISTED_RENTAL -> new BigDecimal("0.5");
            case BIC_NON_LISTED_RENTAL -> new BigDecimal("0.3");
            case BNC -> new BigDecimal("0.34");
            default -> throw new IllegalArgumentException("MicroTaxCalculator => Catégorie micro fiscale inconnue : " + activity.getTaxCategory());
        };
    }

    public BigDecimal calculateDeduction(BigDecimal turnover, BusinessActivity activity) {
        BigDecimal calculatedDeduction = turnover.multiply(getDeductionRate(activity));
        return calculatedDeduction.max(MINIMUM_TAX_DEDUCTION);
    }

    public BigDecimal getTaxWithholdingRate(BusinessActivity activity) {
        return switch (activity.getTaxCategory()) {
            case BIC_SALES -> new BigDecimal("0.01");
            case BIC_SERVICES, BIC_LISTED_RENTAL, BIC_NON_LISTED_RENTAL -> new BigDecimal("0.017");
            case BNC -> new BigDecimal("0.022");
            default -> throw new IllegalArgumentException("MicroTaxCalculator => Catégorie micro fiscale inconnue : " + activity.getTaxCategory());
        };
    }

    public BigDecimal calculateTaxWithholding(BigDecimal turnover, BusinessActivity activity) {
        return turnover.multiply(getTaxWithholdingRate(activity));
    }
}
