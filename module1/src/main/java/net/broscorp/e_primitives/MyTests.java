import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTests {

    private static TestMethods tester;

    @BeforeAll
    public static void initTestedClass() {
        tester = new TestMethods();
    }

    @Test
    public void intOverflowTest() {
        assertEquals(Integer.MIN_VALUE + 9 ,
                tester.intValueAddition(Integer.MAX_VALUE, 10),
                "Integer is overflowed after operation");
    }

    @Test
    public void floatToDoubleConversionTest() {
        assertEquals(10.23d ,
                tester.floatToDouble(10.23f),
                "10.23f should be 10.23d");
    }

    @Test
    public void longToIntConversionTest() {
        long value = Integer.MAX_VALUE + 10;
        assertEquals(Integer.MIN_VALUE + 9,
                tester.longToInt(value),
                "Value is incorrect after conversion");
    }

    @Test
    public void doublePrecisionTest() {
        assertEquals(1.0,
                tester.incDouble(0.0, 0.1, 10),
                "0.0 + 10 x 0.1 must be 1.0");

    }

}
