package fr.sebaseg.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculatorUnderTest;
    private static Instant startedAt;

    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }

    @BeforeEach
    public void initCalculator() {
        calculatorUnderTest = new Calculator();
        System.out.println("Appel avant chaque test");
    }

    @AfterEach
    public void undefCalculator() {
        System.out.println("Appel après chaque test");
        calculatorUnderTest = null;
    }

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculatorUnderTest.add(a, b);

        // Assert
        assertThat(somme).isEqualTo(5);
    }

    @Test
    void multiply_shouldReturnTheProduct_ofTwoIntegers() {
        int a = 2;
        int b = 3;

        int product = calculatorUnderTest.multiply(a, b);

        assertThat(product).isEqualTo(6);
    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = {1, 2, 42, 1001, 5089})
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        int actualResult = calculatorUnderTest.multiply(arg, 0);
        assertThat(actualResult).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} + {1} doit être égal à {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
        int actualResult = calculatorUnderTest.add(arg1, arg2);
        assertThat(actualResult).isEqualTo(expectResult);
    }

    @Test
    @Timeout(value = 1)
    public void longCalcul_shouldComputeInLessThan1Second() {
        calculatorUnderTest.longCalculation();
    }

    @Test
    public void listDigits_shouldReturnTheListOfDigits_ofPositiveIntegers() {
        int number = 67867544;

        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        Set<Integer> expectedDigits = Stream.of(6, 7, 8, 6, 7, 5, 4, 4).collect(Collectors.toSet());
        assertEquals(expectedDigits, actualDigits);

        assertThat(actualDigits).containsExactlyInAnyOrder(4, 5, 6, 7, 8);
    }

    @Test
    public void listDigits_shouldReturnTheListOfDigits_ofNegativeIntegers() {
        int number = -67867544;
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
        assertThat(actualDigits).containsExactlyInAnyOrder(4, 5, 6, 7, 8);
    }

    @Test
    public void listDigits_shouldReturnTheListOfZeros_ofZero() {
        int number = 0;
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
        assertThat(actualDigits).containsExactly(0);
    }
}
