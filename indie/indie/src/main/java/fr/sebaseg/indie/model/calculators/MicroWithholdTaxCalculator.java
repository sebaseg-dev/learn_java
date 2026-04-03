package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class MicroWithholdTaxCalculator implements FlatTaxCalculator {
    private final JsonRatesProvider ratesProvider;

    public MicroWithholdTaxCalculator(JsonRatesProvider ratesProvider) {
        this.ratesProvider = ratesProvider;
    }

    @Override
    public BigDecimal getRate(BusinessActivity activity) {
        return ratesProvider.getLatestRate(ratesProvider.getConfig().microWithholdTaxRates(), activity.getTaxCategory().name());
    }
}
