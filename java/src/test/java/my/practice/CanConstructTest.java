package my.practice;

import my.practice.converter.StringArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class CanConstructTest {

    @ParameterizedTest
    @CsvSource({
            "abcdef                                 , ab abc cd def abcd         , true",
            "skateboard                             , bo rd ate t ska sk boar    , false",
            "enterapotentpot                        , a p ent enter ot o t       , true",
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef, e ee eee eeee eeeee eeeeee, false"
    })
    public void testShortestSum(String targetString,
                                @ConvertWith(StringArrayConverter.class) String[] wordBank,
                                boolean expectedCanConstruct) {

        boolean actualCanConstruct = CanConstruct.check(targetString, wordBank);
        Assertions.assertEquals(expectedCanConstruct, actualCanConstruct, "Failed to form " + targetString);
    }
}