package my.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GridTravellerTest {

    @ParameterizedTest
    @CsvSource({
            "1,1,1",
            "10,0,0",
            "0,10,0",
            "2,3,3",
            "3,2,3",
            "3,3,6",
            "4,4,20",
            "18,18,2333606220"
    })
    public void testGridTraveller(int rows, int columns, long expectedRoutes) {

        long actualRoutes = GridTraveller.getRoutes(rows, columns);
        Assertions.assertEquals(expectedRoutes, actualRoutes);
    }
}