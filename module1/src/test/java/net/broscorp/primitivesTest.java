package net.broscorp;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class primitivesTest {

    @Test
    public void shouldBeNegative(){
        int maxIntValue = Integer.MAX_VALUE;

        int overMax = maxIntValue + 1;

        assertTrue(overMax < 0);
    }

    @Test
    public void longToIntConvertation(){
        long a = Long.MAX_VALUE;

        int b = (int) a;

        assertNotEquals(a, b);
    }

    @Test
    public void floatToDoubleConvertation(){
        float a = 158.168f ;

        double b = a;

        assertNotEquals(158.168, b);
    }

    @Test
    public void errorsWhileWorkingWithFloats(){
        float a = 2.5f + 2.7f;

        assertNotEquals(5.2, a);
    }
}
