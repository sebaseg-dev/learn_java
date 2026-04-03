package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.config.IncomeTaxScale;
import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class RevenueTaxCalculator {
    private final JsonRatesProvider ratesProvider;

    public RevenueTaxCalculator(JsonRatesProvider ratesProvider) {
        this.ratesProvider = ratesProvider;
    }

    public BigDecimal calculate(BigDecimal turnover, BusinessActivity activity) {
        IncomeTaxScale taxScale = ratesProvider.getLatestIncomeTaxScale();
        return calculateTax(turnover, activity, taxScale);
    }

    public BigDecimal getDeductionRate(BusinessActivity activity) {
        return ratesProvider.getLatestRate(ratesProvider.getConfig().revenueDeductionRates(), activity.getTaxCategory().name());
    }

    public BigDecimal calculateDeduction(BigDecimal turnover, BusinessActivity activity) {
        BigDecimal calculatedDeduction = turnover.multiply(getDeductionRate(activity));
        BigDecimal minimumTaxDeductionAmount = turnover.min(ratesProvider.getLatestMinimumTaxDeductionAmount(ratesProvider.getConfig().revenueDeductionRates()));
        return calculatedDeduction.max(minimumTaxDeductionAmount);
    }

    public BigDecimal calculateTaxableRevenue(BigDecimal turnover, BusinessActivity activity) {
        return turnover.subtract(calculateDeduction(turnover, activity));
    }

    /**
     * Calculates the total tax based on the provided turnover, business activity, and income tax scale.
     * The calculation accounts for multiple tax brackets, applying the appropriate rate to each bracket.
     *
     * @param turnover The total revenue on which the tax is calculated.
     * @param activity The type of business activity, which determines tax deductions and rates.
     * @param scale The income tax scale, specifying the tax brackets and rates applicable.
     * @return The total tax amount as a {@code BigDecimal}.
     */
    public BigDecimal calculateTax(BigDecimal turnover, BusinessActivity activity, IncomeTaxScale scale) {
        BigDecimal taxableRevenue = calculateTaxableRevenue(turnover, activity);

        BigDecimal threshold = new BigDecimal("0");
        BigDecimal tax = new BigDecimal("0");
        int index = 0;

        while (taxableRevenue.compareTo(threshold) > 0) {
            BigDecimal limit = scale.brackets().get(index).limit();

            if (limit == null) {
                tax = tax.add(taxableRevenue.subtract(threshold).multiply(scale.brackets().get(index).rate()));
                break;
            }

            BigDecimal taxableBracket = (limit.min(taxableRevenue)).subtract(threshold);
            tax = tax.add(taxableBracket.multiply(scale.brackets().get(index).rate()));
            index++;
            threshold = limit;
        }

        return tax;
    }

}
