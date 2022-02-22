package my.practice;

import my.practice.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class CanSumTest {

    @ParameterizedTest
    @CsvSource({
            "300, 7 14      ,     false"
    })
    public void testCanSum(int targetSum,
                              @ConvertWith(IntArrayConverter.class) int[] numbers,
                              boolean expectedCanSum) {
        final boolean actualCanSum = CanSum.canSum(targetSum, numbers);
        Assertions.assertEquals(expectedCanSum, actualCanSum);
    }
}