package fr.sebaseg.indie.model.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class SimulationResultTest {

    @Test
    void When_creatingCorrectSimulationResult_Then_itShouldHoldCorrectValues() {
        BigDecimal turnover = new BigDecimal("1000.0");
        BigDecimal taxWithholding = new BigDecimal("100.0");
        BigDecimal revenueTaxes = new BigDecimal("10.0");
        BigDecimal socialContribution = new BigDecimal("42.42");
        BigDecimal professionalTrainingContribution = new BigDecimal("0.01990");
        BigDecimal netIncomeAfterWithholdingTaxes = turnover.subtract(taxWithholding).subtract(socialContribution).subtract(professionalTrainingContribution);
        BigDecimal netIncomeAfterRevenueTaxes = turnover.subtract(revenueTaxes).subtract(socialContribution).subtract(professionalTrainingContribution);

        SimulationResult result = new SimulationResult(
                turnover,
                taxWithholding,
                revenueTaxes,
                socialContribution,
                professionalTrainingContribution,
                netIncomeAfterWithholdingTaxes,
                netIncomeAfterRevenueTaxes
        );

        assertThat(result.turnover()).isEqualTo(turnover);
        assertThat(result.taxWithholding()).isEqualTo(taxWithholding);
        assertThat(result.revenueTaxes()).isEqualTo(revenueTaxes);
        assertThat(result.socialContribution()).isEqualTo(socialContribution);
        assertThat(result.professionalTrainingContribution()).isEqualTo(professionalTrainingContribution);
        assertThat(result.netIncomeAfterWithholdingTaxes()).isEqualTo(netIncomeAfterWithholdingTaxes);
        assertThat(result.netIncomeAfterRevenueTaxes()).isEqualTo(netIncomeAfterRevenueTaxes);
    }

    @ParameterizedTest
    @MethodSource("provideNullParameters")
    void When_creatingASimulationResultWithNullParameters_Then_itShouldThrowAnException(
            BigDecimal turnover,
            BigDecimal taxWithholding,
            BigDecimal revenueTaxes,
            BigDecimal socialContribution,
            BigDecimal professionalTrainingContribution,
            BigDecimal netIncomeAfterWithholdingTaxes,
            BigDecimal netIncomeAfterRevenueTaxes
    ) {
        assertThatThrownBy(() -> new SimulationResult(
                turnover,
                taxWithholding,
                revenueTaxes,
                socialContribution,
                professionalTrainingContribution,
                netIncomeAfterWithholdingTaxes,
                netIncomeAfterRevenueTaxes)
        )
                .isInstanceOf(NullPointerException.class);

    }

    @Test
    void When_netIncomeAfterWithholdingTaxIsIncoherent_Then_itShouldThrowAnException() {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal netIncomeAfterWithholdingTaxes = new BigDecimal("1000.0");

        assertThatThrownBy(() -> new SimulationResult(
                zero,
                zero,
                zero,
                zero,
                zero,
                netIncomeAfterWithholdingTaxes,
                zero
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incohérence détectée : le revenu net (" + netIncomeAfterWithholdingTaxes +
                        ") ne correspond pas au calcul (CA - Charges = " + zero + ")");
    }

    @Test
    void When_netIncomeAfterRevenueTaxIsIncoherent_Then_itShouldThrowAnException() {
        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal netIncomeAfterRevenueTaxes = new BigDecimal("1000.0");

        assertThatThrownBy(() -> new SimulationResult(
                zero,
                zero,
                zero,
                zero,
                zero,
                zero,
                netIncomeAfterRevenueTaxes
        ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Incohérence détectée : le revenu net (" + netIncomeAfterRevenueTaxes +
                        ") ne correspond pas au calcul (CA - Charges = " + zero + ")");
    }

    static Stream<Arguments> provideNullParameters() {
        BigDecimal zero = BigDecimal.ZERO;
        return Stream.of(
                Arguments.of(null, zero, zero, zero, zero, zero, zero),
                Arguments.of(zero, null, zero, zero, zero, zero, zero),
                Arguments.of(zero, zero, null, zero, zero, zero, zero),
                Arguments.of(zero, zero, zero, null, zero, zero, zero),
                Arguments.of(zero, zero, zero, zero, null, zero, zero),
                Arguments.of(zero, zero, zero, zero, zero, null, zero),
                Arguments.of(zero, zero, zero, zero, zero, zero, null)
        );
    }
}
