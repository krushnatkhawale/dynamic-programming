package my.practice;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciSeriesTest {

    // 1, 2, 3, 4, 5, 6,  7,  8,  9, 10, 11,  12, ...,     28,       40
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ..., 317811, 63245986
    @ParameterizedTest
    @CsvSource({"1, 1", "2, 1","3, 2","4, 3", "6, 8", "10, 55", "12, 144",
                "28, 317811", "40, 102334155", "50, 12586269025", "80, 23416728348467685"})
    public void testFactorial(int position, long expectedValue) {
        long actualTerm = FibonacciSeries.getNthTerm(position);
        Assertions.assertEquals(expectedValue, actualTerm);
    }
}