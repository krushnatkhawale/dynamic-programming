package my.practice;

import my.practice.converter.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class HowSumTest {

    @ParameterizedTest
    @CsvSource({
            "7  , 2 3       ,     3 2 2",
            "7  , 5 3 4 7   ,     4 3",
            "7  , 2 4       ,     null",
            "8  , 2 3 5     ,     2 2 2 2",
            "300, 7 14      ,     null"
    })
    public void testHowSum(int targetSum,
                           @ConvertWith(IntArrayConverter.class) int[] numbers,
                           @ConvertWith(IntArrayConverter.class) int[] expectedSumCombo) {
        final int[] actualSumCombo = HowSum.howSum(targetSum, numbers);
        Assertions.assertArrayEquals(expectedSumCombo, actualSumCombo);
    }
}