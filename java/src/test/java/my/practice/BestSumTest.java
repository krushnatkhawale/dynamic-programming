package my.practice;

import my.practice.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class BestSumTest {

    @ParameterizedTest
    @CsvSource({
            "7  , 5 3 4 7   ,     7",
            "8  , 2 3 5     ,     3 5",
            "8  , 1 4 5     ,     4 4",
            "100, 1 2 5 25  ,     25 25 25 25"
    })
    public void testShortestSum(int targetSum,
                           @ConvertWith(IntArrayConverter.class) int[] numbers,
                           @ConvertWith(IntArrayConverter.class) int[] expectedSumCombo) {
        final int[] actualSumCombo = BestSum.bestSum(targetSum, numbers);
        Assertions.assertNotNull(actualSumCombo);
        Arrays.sort(expectedSumCombo);
        Arrays.sort(actualSumCombo);
        Assertions.assertArrayEquals(expectedSumCombo, actualSumCombo);
    }
}