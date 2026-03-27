package fr.sebaseg.indie.model.config;

import java.math.BigDecimal;
import java.util.Map;

public record RateEntry(
    String applicableFrom,
    Map<String, BigDecimal> rates,
    BigDecimal minimumTaxDeductionAmount,
    String sourceUrl
) {

}
