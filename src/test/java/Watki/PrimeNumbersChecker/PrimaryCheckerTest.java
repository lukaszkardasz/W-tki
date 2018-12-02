package Watki.PrimeNumbersChecker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class PrimaryCheckerTest {

    @ParameterizedTest
    @MethodSource (value = "getPrimeNumbers")
    public void testIsPrime(long number, boolean expectedResult) {
        //given
        PrimaryChecker checker = new PrimaryChecker();
        //when
        boolean result = checker.isPrime(number);
        //then
        Assertions.assertEquals(result, expectedResult);
    }

    static Stream<Arguments> getPrimeNumbers() {
        return Stream.of (
                Arguments.of(3L, true),
                Arguments.of(5L, true),
                Arguments.of(6L, false),
                Arguments.of(100L, false)
                );
    }
}