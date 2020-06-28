package task2;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("positive test int addition")
    @Tag("positive")
    @MethodSource("provideArgumentsForIntAdditionPositiveTest")
    void positiveTestIntAddition(int firstArgument, int secondArgument, int result) {
        Assertions.assertEquals(result, calculator.add(firstArgument, secondArgument));
    }

    private static Stream<Arguments> provideArgumentsForIntAdditionPositiveTest() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, 0, -1),
                Arguments.of(14, 16, 30)
        );
    }

    @ParameterizedTest
    @DisplayName("test double addition")
    @Tag("positive")
    @MethodSource("provideArgumentsForDoubleAdditionPositiveTest")
    void positiveTestDoubleAddition(double firstArgument, double secondArgument, double result) {
        Assertions.assertEquals(result, calculator.add(firstArgument, secondArgument));
    }

    private static Stream<Arguments> provideArgumentsForDoubleAdditionPositiveTest() {
        return Stream.of(
                Arguments.of(1.33, 2.4, 3.73),
                Arguments.of(0.0002, 1.1, 1.1002)

        );
    }

    @ParameterizedTest
    @Tag("negative")
    @DisplayName("negative test int addition")
    @MethodSource("provideArgumentsForIntAdditionNegativeTest")
    void negativeTestIntAddition(int firstArgument, int secondArgument, int result) {
        Assertions.assertNotEquals(result, calculator.add(firstArgument, secondArgument));
    }

    private static Stream<Arguments> provideArgumentsForIntAdditionNegativeTest() {
        return Stream.of(
                Arguments.of(0, 2, 4),
                Arguments.of(0, -1, 0),
                Arguments.of(-3, 0, -1),
                Arguments.of(14, 16, -4)
        );
    }

    @ParameterizedTest
    @Tag("negative")
    @DisplayName("test double addition")
    @MethodSource("provideArgumentsForDoubleAdditionNegativeTest")
    void negativeTestIntAddition(double firstArgument, double secondArgument, double result) {
        Assertions.assertNotEquals(result, calculator.add(firstArgument, secondArgument));
    }

    private static Stream<Arguments> provideArgumentsForDoubleAdditionNegativeTest() {
        return Stream.of(
                Arguments.of(1.02, 2, 3),
                Arguments.of(0, -1.5, -1)
        );
    }

    @Test
    @Tag("positive")
    void positiveTestDoubleDivision() {
        Assertions.assertEquals(1.2, calculator.divide(1.2, 1.0));
    }

    @Test
    @Tag("positive")
    void positiveTestDoubleDivisionIllegalArgumentException() {
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> calculator.divide(1.2, 0)),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> calculator.divide(0, 0))
        );
    }

    @Test
    @Tag("positive")
    void positiveTestIsPrimeTimeout() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> calculator.isPrime(434364));
    }

    @Test
    @Tag("negative")
    void negativeTestIsPrimeEdgeCases() {
        Assertions.assertAll(
                () -> Assertions.assertFalse(calculator.isPrime(0)),
                () -> Assertions.assertFalse(calculator.isPrime(-1)),
                () -> Assertions.assertFalse(calculator.isPrime(1))
        );
    }

    @Test
    @Tag("positive")
    void positiveTestFibonacciZero(){
        MatcherAssert.assertThat(calculator.findFibonacciByBinetsFormula(0), Matchers.equalTo(0));
    }

    @Test
    @Tag("positive")
    void positiveTestFibonacciFirst(){
        MatcherAssert.assertThat(calculator.findFibonacciByBinetsFormula(1), Matchers.equalTo(1));
    }

    @Test
    @Tag("positive")
    void positiveTestFibonacciSecond(){
        MatcherAssert.assertThat(calculator.findFibonacciByBinetsFormula(2), Matchers.equalTo(1));
    }

    @Test
    @Tag("positive")
    void positiveTestFibonacciThird(){
        MatcherAssert.assertThat(calculator.findFibonacciByBinetsFormula(3), Matchers.equalTo(2));
    }


}