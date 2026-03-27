package fr.sebaseg.indie.model.config;

import java.util.List;

public record RatesConfig(
    List<RateEntry> microSocialRates,
    List<RateEntry> microWithholdTaxRates,
    List<RateEntry> professionalTrainingContributionRates,
    List<RateEntry> revenueDeductionRates
) {
}
