package fr.sebaseg.indie.model.service;

import java.math.BigDecimal;
import java.util.Objects;

public record SimulationResult(
        BigDecimal turnover,
        BigDecimal taxWithholding,
        BigDecimal revenueTaxes,
        BigDecimal socialContribution,
        BigDecimal professionalTrainingContribution,
        BigDecimal netIncomeAfterWithholdingTaxes,
        BigDecimal netIncomeAfterRevenueTaxes)
{
    public SimulationResult {
        Objects.requireNonNull(turnover);
        Objects.requireNonNull(taxWithholding);
        Objects.requireNonNull(revenueTaxes);
        Objects.requireNonNull(socialContribution);
        Objects.requireNonNull(professionalTrainingContribution);
        Objects.requireNonNull(netIncomeAfterWithholdingTaxes);
        Objects.requireNonNull(netIncomeAfterRevenueTaxes);

        BigDecimal expectedNetIncomeAfterWithholdingTaxes = turnover
                .subtract(taxWithholding)
                .subtract(socialContribution)
                .subtract(professionalTrainingContribution);

        if (expectedNetIncomeAfterWithholdingTaxes.compareTo(netIncomeAfterWithholdingTaxes) != 0) {
            throw new IllegalArgumentException(
                "Incohérence détectée : le revenu net (" + netIncomeAfterWithholdingTaxes +
                ") ne correspond pas au calcul (CA - Charges = " + expectedNetIncomeAfterWithholdingTaxes + ")"
            );
        }

        BigDecimal expectedNetIncomeAfterRevenueTaxes = turnover
                .subtract(revenueTaxes)
                .subtract(socialContribution)
                .subtract(professionalTrainingContribution);

        if (expectedNetIncomeAfterRevenueTaxes.compareTo(netIncomeAfterRevenueTaxes) != 0) {
            throw new IllegalArgumentException(
                "Incohérence détectée : le revenu net (" + netIncomeAfterRevenueTaxes +
                ") ne correspond pas au calcul (CA - Charges = " + expectedNetIncomeAfterRevenueTaxes + ")"
            );
        }
    }
}
