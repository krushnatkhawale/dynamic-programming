package my.practice;

import my.practice.converter.StringArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class CountConstructTest {

    @ParameterizedTest
    @CsvSource({
            "purple                                 , purp p ur le purpl         , 2",
            "abcdef                                 , ab abc cd def abcd         , 1",
            "skateboard                             , bo rd ate t ska sk boar    , 0",
            "enterapotentpot                        , a p ent enter ot o t       , 4",
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, e ee eee eeee eeeee eeeeee, 0"
    })
    public void testConstructsCountedCorrectly(String targetString,
                                @ConvertWith(StringArrayConverter.class) String[] wordBank,
                                int expectedConstructCount) {

        int actualConstructCount = CountConstruct.check(targetString, wordBank);
        Assertions.assertEquals(expectedConstructCount, actualConstructCount, "Number of construct mismatch for " + targetString);
    }
}