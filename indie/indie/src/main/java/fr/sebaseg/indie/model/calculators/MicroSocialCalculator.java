package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.model.data.BusinessActivity;

import java.math.BigDecimal;

public class MicroSocialCalculator implements CalculatorInterface {
    private final JsonRatesProvider ratesProvider;

    public MicroSocialCalculator(JsonRatesProvider ratesProvider) {
        this.ratesProvider = ratesProvider;
    }

    @Override
    public BigDecimal getRate(BusinessActivity activity) {
        return ratesProvider.getLatestRate(ratesProvider.getConfig().microSocialRates(), activity.getSocialCategory().name());
    }
}
