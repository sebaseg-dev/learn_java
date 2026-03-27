package fr.sebaseg.indie.model.config;


import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.List;

public class JsonRatesProvider {
    private final RatesConfig config;

    public JsonRatesProvider() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            config = mapper.readValue(getClass().getResourceAsStream("/rates.json"), RatesConfig.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BigDecimal getLatestRate(List<RateEntry> entries, String categoryKey) {
        RateEntry latest = entries.get(0);
        return latest.rates().get(categoryKey);
    }

    public BigDecimal getLastestMinimumTaxDeductionAmount(List<RateEntry> entries) {
        RateEntry latest = entries.get(0);
        return latest.minimumTaxDeductionAmount();
    }

    public RatesConfig getConfig() {
        return config;
    }
}
