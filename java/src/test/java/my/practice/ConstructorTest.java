package my.practice;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;

public class ConstructorTest {

    @ParameterizedTest
    @CsvSource({
            "my.practice.CanSum",
            "my.practice.HowSum",
            "my.practice.FibonacciSeries",
            "my.practice.GridTraveller"
    })
    public void testThatClassesCannotBeInstantiated(String className) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Assertions.assertThrows(IllegalAccessException.class, () -> {
            Class.forName(className).getDeclaredConstructors()[0]
                    .newInstance();
        });
    }
}