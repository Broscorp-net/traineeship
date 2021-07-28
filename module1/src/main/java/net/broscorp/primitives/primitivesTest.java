package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class primitivesTest {
    @DisplayName("Integer overflow ")
    @Test
    void overflowNumber() {
        int integer = Integer.MAX_VALUE + 1;
        Assertions.assertEquals(Integer.MIN_VALUE, integer);
    }

    @DisplayName("Conversion long to integer")
    @Test
    void conversionInteger(){
        long l = Long.MAX_VALUE;
        int integer = (int) l;
        Assertions.assertEquals(-858993460, integer);
    }

    @DisplayName("Conversion float to double")
    @Test
    void conversionFloat(){
        float valueFloat = 1.4e-10f;
        double valueDouble = valueFloat;
        Assertions.assertEquals(valueDouble,valueFloat);
    }

    @Test
    void infelicity(){
        double a = 2.0 - 1.1;
        Assertions.assertEquals(0.8999999999999999, a);
    }
}
