package my.practice.converter;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class IntArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String) {
            if("null".equals((String) source)){
                return null;
            }else {
                final String[] inputArray = ((String) source).split(" ");
                final int[] outputArray = new int[inputArray.length];
                for (int i = 0; i < inputArray.length; i++) {
                    outputArray[i] = Integer.parseInt(inputArray[i]);
                }
                return outputArray;
            }
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}