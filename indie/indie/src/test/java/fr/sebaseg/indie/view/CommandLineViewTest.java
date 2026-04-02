package fr.sebaseg.indie.view;

import fr.sebaseg.indie.model.service.SimulationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommandLineViewTest {
    @Mock
    private SimulationResult results;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private CommandLineView view;

    @BeforeEach
    void setUp() {
        view = new CommandLineView(System.in, new PrintStream(outContent));
    }

    @Test
    void should_ReturnUserInput_When_PromptingForActivity() {
        InputStream in = new ByteArrayInputStream("1\n".getBytes());
        view = new CommandLineView(in, new PrintStream(outContent));

        String result = view.promptForActivity(new String[]{"Valeur1", "Valeur2"});

        assertEquals("1", result);
        assertTrue(outContent.toString().contains("Valeur1")); // Vérifie que l'option a été affichée
    }

    @Test
    void should_FormatCurrencyCorrectly_In_Results() {
        when(results.turnover()).thenReturn(new BigDecimal("10000.00"));
        when(results.taxWithholding()).thenReturn(new BigDecimal("220.555"));
        when(results.revenueTaxes()).thenReturn(new BigDecimal("0.00"));
        when(results.socialContribution()).thenReturn(new BigDecimal("0.00"));
        when(results.professionalTrainingContribution()).thenReturn(new BigDecimal("0.00"));
        when(results.netIncomeAfterWithholdingTaxes()).thenReturn(new BigDecimal("7750.00"));
        when(results.netIncomeAfterRevenueTaxes()).thenReturn(new BigDecimal("7750.00"));

        view.showResults(results);

        String output = outContent.toString();

        assertTrue(output.contains("+ Chiffre d'affaires"));
        assertTrue(output.contains("- 220,56 €"));
        assertTrue(output.contains("- 7 750,00 €"));
    }
}
