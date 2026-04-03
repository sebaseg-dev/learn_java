package fr.sebaseg.testing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import fr.sebaseg.testing.service.CalculatorService;
import fr.sebaseg.testing.service.CalculatorServiceImpl;
import fr.sebaseg.testing.service.SolutionFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.sebaseg.testing.domain.Calculator;
import fr.sebaseg.testing.domain.model.CalculationModel;
import fr.sebaseg.testing.domain.model.CalculationType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    Calculator calculator;

    @Mock
    SolutionFormatter solutionFormatter;

    CalculatorService classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new CalculatorServiceImpl(calculator, solutionFormatter);
    }

    @Test
    public void calculate_shouldUseCalculator_forAddition() {
        when(calculator.add(1, 2)).thenReturn(3);

        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();

        verify(calculator).add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_shouldUseCalculator_forAnyAddition() {
        // GIVEN
        final Random r = new Random();
        when(calculator.add(any(Integer.class), any(Integer.class))).thenReturn(3);

        // WHEN
        final int result = classUnderTest.calculate(
                new CalculationModel(CalculationType.ADDITION,
                        r.nextInt(), r.nextInt())).getSolution();

        // THEN
        verify(calculator).add(any(Integer.class), any(Integer.class));
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void calculate_shouldThrowIllegalArgumentException_forADivisionBy0() {
        // GIVEN
        when(calculator.divide(1, 0)).thenThrow(new ArithmeticException());

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> classUnderTest.calculate(
                new CalculationModel(CalculationType.DIVISION, 1, 0)));

        // THEN
        verify(calculator, times(1)).divide(1, 0);
    }

    @Test
    public void calculate_shouldFormatSolution_forAnAddition() {
        // GIVEN
        when(calculator.add(10000, 3000)).thenReturn(13000);
        when(solutionFormatter.format(13000)).thenReturn("13 000");

        // WHEN
        final String formattedResult = classUnderTest
                .calculate(new CalculationModel(CalculationType.ADDITION, 10000, 3000))
                .getFormattedSolution();

        // THEN
        assertThat(formattedResult).isEqualTo("13 000");
    }


}