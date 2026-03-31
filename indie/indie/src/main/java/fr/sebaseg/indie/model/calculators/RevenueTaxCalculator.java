package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class RevenueTaxCalculator implements CalculatorInterface {
    private final JsonRatesProvider ratesProvider;
    private final BigDecimal minimumTaxDeductionAmount;

    public RevenueTaxCalculator(JsonRatesProvider ratesProvider) {
        this.ratesProvider = ratesProvider;
        this.minimumTaxDeductionAmount = ratesProvider.getLatestMinimumTaxDeductionAmount(ratesProvider.getConfig().revenueDeductionRates());
    }

    @Override
    public BigDecimal getRate(BusinessActivity activity) {
        return new BigDecimal("0");
    }

    @Override
    public BigDecimal calculate(BigDecimal turnover, BusinessActivity activity) {
        return new BigDecimal("0");
    }

    public BigDecimal getDeductionRate(BusinessActivity activity) {
        return ratesProvider.getLatestRate(ratesProvider.getConfig().revenueDeductionRates(), activity.getTaxCategory().name());
    }

    public BigDecimal calculateDeduction(BigDecimal turnover, BusinessActivity activity) {
        BigDecimal calculatedDeduction = turnover.multiply(getDeductionRate(activity));
        return calculatedDeduction.max(minimumTaxDeductionAmount);
    }

}
