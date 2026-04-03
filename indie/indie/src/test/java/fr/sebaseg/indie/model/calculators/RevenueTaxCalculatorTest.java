package fr.sebaseg.indie.model.calculators;

import fr.sebaseg.indie.model.config.IncomeTaxScale;
import fr.sebaseg.indie.model.config.JsonRatesProvider;
import fr.sebaseg.indie.model.config.RatesConfig;
import fr.sebaseg.indie.model.config.TaxBracket;
import fr.sebaseg.indie.model.data.BusinessActivity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RevenueTaxCalculatorTest {
    @ParameterizedTest(name = "Tax for {0} should be {1}")
    @MethodSource("taxCases")
    void shouldCalculateTax(BigDecimal turnover, BigDecimal expectedTax) {
        JsonRatesProvider provider = mock(JsonRatesProvider.class);
        RatesConfig config = mock(RatesConfig.class);
        RevenueTaxCalculator taxCalculator = new RevenueTaxCalculator(provider);
        BusinessActivity activity = BusinessActivity.SALES;

        IncomeTaxScale scale = new IncomeTaxScale(
                "2026-01-01",
                List.of(
                    new TaxBracket(new BigDecimal("1000"), new BigDecimal("0.00")),
                    new TaxBracket(new BigDecimal("25000"), new BigDecimal("0.25")),
                    new TaxBracket(null, new BigDecimal("0.50"))
                ),
                "test-source"
        );

        when(provider.getConfig()).thenReturn(config);
        when(config.revenueDeductionRates()).thenReturn(List.of());
        when(provider.getLatestIncomeTaxScale()).thenReturn(scale);
        when(provider.getLatestRate(any(), anyString())).thenReturn(new BigDecimal("0.10"));
        when(provider.getLatestMinimumTaxDeductionAmount(any())).thenReturn(new BigDecimal("4242"));

        BigDecimal tax = taxCalculator.calculate(turnover, activity);

        assertEquals(0, expectedTax.compareTo(tax));

    }

    private static Stream<Arguments> taxCases() {
        return Stream.of(
                Arguments.of(new BigDecimal("1000.0"), new BigDecimal("0.0")),
                Arguments.of(new BigDecimal("29242"), new BigDecimal("6000.0")),
                Arguments.of(new BigDecimal("50000"), new BigDecimal("16000.0")),
                Arguments.of(new BigDecimal("100000.0"), new BigDecimal("38500.0"))
        );
    }
}
