package fr.sebaseg.indie.model.service;

import fr.sebaseg.indie.model.calculators.FlatTaxCalculator;
import fr.sebaseg.indie.model.calculators.RevenueTaxCalculator;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.data.EntrepreneurProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

public class SimulationServiceTest {
    private FlatTaxCalculator taxCalculator;
    private FlatTaxCalculator socialContributionCalculator;
    private FlatTaxCalculator trainingContributionCalculator;
    private RevenueTaxCalculator revenueTaxCalculator;
    private SimulationService simulationService;

    @BeforeEach
    void setUp() {
        taxCalculator = mock(FlatTaxCalculator.class);
        socialContributionCalculator = mock(FlatTaxCalculator.class);
        trainingContributionCalculator = mock(FlatTaxCalculator.class);
        revenueTaxCalculator = mock(RevenueTaxCalculator.class);
        simulationService = new SimulationService(
                taxCalculator,
                socialContributionCalculator,
                trainingContributionCalculator,
                revenueTaxCalculator
        );
    }

    @ParameterizedTest
    @EnumSource(BusinessActivity.class)
    void When_runSimulation_Then_returnSimulationResult(BusinessActivity activity) {
        BigDecimal turnover = new BigDecimal("10000.0");
        EntrepreneurProfile profile = new EntrepreneurProfile(activity, false, true, turnover);

        when(socialContributionCalculator.calculate(turnover, activity)).thenReturn(new BigDecimal("100.0"));
        when(trainingContributionCalculator.calculate(turnover, activity)).thenReturn(new BigDecimal("200.0"));
        when(taxCalculator.calculate(turnover, activity)).thenReturn(new BigDecimal("300.0"));
        when(revenueTaxCalculator.calculate(turnover, activity)).thenReturn(new BigDecimal("400.0"));

        SimulationResult result = simulationService.launchSimulation(profile);

        assertEquals(new BigDecimal("10000.0"), result.turnover());
        assertEquals(new BigDecimal("300.0"), result.taxWithholding());
        assertEquals(new BigDecimal("400.0"), result.revenueTaxes());
        assertEquals(new BigDecimal("100.0"), result.socialContribution());
        assertEquals(new BigDecimal("200.0"), result.professionalTrainingContribution());
        assertEquals(new BigDecimal("9400.0"), result.netIncomeAfterWithholdingTaxes());
        assertEquals(new BigDecimal("9300.0"), result.netIncomeAfterRevenueTaxes());

        verify(socialContributionCalculator).calculate(turnover, activity);
        verify(trainingContributionCalculator).calculate(turnover, activity);
        verify(taxCalculator).calculate(turnover, activity);
        verify(revenueTaxCalculator).calculate(turnover, activity);
    }
}
