package my.practice;

import my.practice.converter.String2DArrayConverter;
import my.practice.converter.StringArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class AllConstructTest {

    @ParameterizedTest
    @CsvSource({
            "purple                                 , purp p ur le purpl         , purp le | p ur p le",
            "abcdef                                 , ab abc cd def abcd ef c    , ab cd ef | ab c def | abc def | abcd ef",
            "skateboard                             , bo rd ate t ska sk boar    , ",
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, e ee eee eeee eeeee eeeeee, "
    })
    public void testConstructsCreation(String targetString,
                                @ConvertWith(StringArrayConverter.class) String[] wordBank,
                                @ConvertWith(String2DArrayConverter.class) String[][] expectedConstructs) {

        String[][] actualConstructs = AllConstructs.construct(targetString, wordBank);
        Assertions.assertEquals(expectedConstructs, actualConstructs, "Number of construct mismatch for " + targetString);
    }
}