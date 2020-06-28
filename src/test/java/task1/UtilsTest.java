package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class UtilsTest {

    private Utils utils = new Utils();
    private Random random = new Random();

    @Test
    void testConcatenateWords() {
        String beginning = "Hel";
        String ending = "lo!";
        Assertions.assertEquals("Hello!", utils.concatenateWords(beginning, ending));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCalculatingFactorial")
    void testComputeFactorial(int inputNumber, int resultFactorial) {
        Assertions.assertEquals(resultFactorial, utils.computeFactorial(inputNumber));
    }

    private static Stream<Arguments> provideArgumentsForCalculatingFactorial() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120)
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.SECONDS)
    void testFactorialWithTimeout() {
        utils.computeFactorial(random.nextInt(Integer.MAX_VALUE));
    }

    @Test
    void timeoutForFactorialCalculation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> utils.computeFactorial(getRandomNegativeNumber()));
    }

    private int getRandomNegativeNumber(){
        return random.nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE;
    }

    @Test
    @Disabled
    void testNormalizeWord(){
        Assertions.assertEquals("schön",utils.normalizeWord("schön"));
    }
}
