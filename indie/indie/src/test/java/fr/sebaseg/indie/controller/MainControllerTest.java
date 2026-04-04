package fr.sebaseg.indie.controller;
import fr.sebaseg.indie.model.calculators.CalculationException;
import fr.sebaseg.indie.model.data.BusinessActivity;
import fr.sebaseg.indie.model.service.SimulationResult;
import fr.sebaseg.indie.model.service.SimulationService;
import fr.sebaseg.indie.view.ViewInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {

    private MainController controller;
    private String[] activityNames;

    @Mock private ViewInterface view;
    @Mock private SimulationService simulationService;

    @BeforeEach
    void setUp() {
        controller = new MainController(view, simulationService);

        activityNames = new String[BusinessActivity.values().length];
        for (int i = 0; i < BusinessActivity.values().length; i++) {
            activityNames[i] = BusinessActivity.values()[i].name();
        }
    }

    @Test
    void when_start_then_fullCycleIsExecuted() {
        // GIVEN
        BigDecimal turnover = new BigDecimal("1000");
        BusinessActivity activity = BusinessActivity.ARTISAN;
        SimulationResult expectedResult = new SimulationResult(
                turnover, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, turnover, turnover
        );

        when(view.promptForActivity(activityNames)).thenReturn(String.valueOf(activity.ordinal()));
        when(view.promptForTurnover()).thenReturn(turnover.toString());
        when(simulationService.launchSimulation(any())).thenReturn(expectedResult);

        // WHEN
        controller.start();

        // THEN
        InOrder inOrder = inOrder(view, simulationService);
        inOrder.verify(view).showWelcomeMessage();
        inOrder.verify(view).promptForActivity(activityNames);
        inOrder.verify(view).promptForTurnover();
        inOrder.verify(view).showActivity(activity);
        inOrder.verify(view).showRevenue(turnover);
        inOrder.verify(simulationService).launchSimulation(argThat(profile ->
                profile.getActivity() == activity && profile.getTurnover().equals(turnover)
        ));
        inOrder.verify(view).showResults(expectedResult);
        inOrder.verify(view).showGoodbyeMessage();
    }

    @ParameterizedTest
    @EnumSource(BusinessActivity.class)
    void when_userInputsActivity_then_itIsAccepted(BusinessActivity activity){
        when(view.promptForActivity(activityNames)).thenReturn(String.valueOf(activity.ordinal()));
        when(view.promptForTurnover()).thenReturn("1000");
        when(simulationService.launchSimulation(any())).thenReturn(mock(SimulationResult.class));

        controller.start();

        verify(view).showActivity(activity);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "-1", "99", ""})
    void when_userInputsInvalidActivity_then_errorIsShownAndUserCanRetry(String invalidInput) {
        when(view.promptForActivity(activityNames)).thenReturn(invalidInput, "0");
        when(view.promptForTurnover()).thenReturn("1000");
        when(simulationService.launchSimulation(any())).thenReturn(mock(SimulationResult.class));

        controller.start();

        verify(view, atLeastOnce()).showErrorMessage(anyString());
        verify(view).showActivity(BusinessActivity.SALES);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "-1", "0", ""})
    void when_userInputsInvalidTurnover_then_errorIsShownAndUserCanRetry(String invalidInput) {
        when(view.promptForActivity(activityNames)).thenReturn("0");
        when(view.promptForTurnover()).thenReturn(invalidInput, "1000");
        when(simulationService.launchSimulation(any())).thenReturn(mock(SimulationResult.class));

        controller.start();

        verify(view, atLeastOnce()).showErrorMessage(anyString());
        verify(view).showRevenue(new BigDecimal("1000"));
    }

    @Test
    @Timeout(1)
    void when_calculationExceptionOccurs_then_errorMessageIsShown() {
        when(view.promptForActivity(activityNames)).thenReturn("0");
        when(view.promptForTurnover()).thenReturn("1000");
        when(simulationService.launchSimulation(any())).thenThrow(new CalculationException("Erreur de calcul"));

        controller.start();

        verify(view).showErrorMessage("Erreur de calcul");
        verify(view).showGoodbyeMessage();
    }
}
