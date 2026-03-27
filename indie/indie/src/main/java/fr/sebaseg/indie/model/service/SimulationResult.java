package fr.sebaseg.indie.model.service;

import java.math.BigDecimal;
import java.util.Objects;

public record SimulationResult(
        BigDecimal turnover,
        BigDecimal revenueTaxes,
        BigDecimal socialContribution,
        BigDecimal professionalTrainingContribution,
        BigDecimal netIncome
) {
    public SimulationResult {
        Objects.requireNonNull(turnover);
        Objects.requireNonNull(revenueTaxes);
        Objects.requireNonNull(socialContribution);
        Objects.requireNonNull(professionalTrainingContribution);
        Objects.requireNonNull(netIncome);

        BigDecimal expectedNetIncome = turnover
                .subtract(revenueTaxes)
                .subtract(socialContribution)
                .subtract(professionalTrainingContribution);

        if (expectedNetIncome.compareTo(netIncome) != 0) {
            throw new IllegalArgumentException(
                "Incohérence détectée : le revenu net (" + netIncome +
                ") ne correspond pas au calcul (CA - Charges = " + expectedNetIncome + ")"
            );
        }
    }
}
