package my.practice.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class String2DArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String) {
            if ("null".equals((String) source)) {
                return null;
            } else {
                final String[] outerArray = ((String) source).split("\\|");
                final String[][] _2DArray = new String[outerArray.length][];
                for (int i = 0; i < outerArray.length; i++) {
                    String innerArrayString = outerArray[i].trim();
                    final String[] singleInnerArray = innerArrayString.split(" ");
                    _2DArray[i] = new String[singleInnerArray.length];
                    for (int j = 0; j < singleInnerArray.length; j++) {
                        _2DArray[i][j] = singleInnerArray[j];
                    }
                }
                return _2DArray;
            }
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}