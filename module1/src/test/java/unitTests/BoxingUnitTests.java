package unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoxingUnitTests {

    @Test
    public void compareWrappersByte() {
        Byte byte1 = 10;
        Byte byte2 = 10;
        Assertions.assertTrue(byte1 == byte2);
        byte1 = -120;
        byte2 = -120;
        Assertions.assertTrue(byte1 == byte2);
    }

    @Test
    public void compareWrappersInteger() {
        Integer integer1 = 10;
        Integer integer2 = 10;
        Assertions.assertTrue(integer1 == integer2);//Integer pool
        integer1 = 130;
        integer2 = 130;
        Assertions.assertFalse(integer1 == integer2);
    }

    @Test
    public void compareWrappersShort() {
        Short short1 = 10;
        Short short2 = 10;
        Assertions.assertTrue(short1 == short2);//Short pool
        short1 = 130;
        short2 = 130;
        Assertions.assertFalse(short1 == short2);
    }

    @Test
    public void compareWrappersLong() {
        Long long1 = 100L;
        Long long2 = 100L;
        Assertions.assertTrue(long1 == long2);//Long pool
        long1 = 150L;
        long2 = 150L;
        Assertions.assertFalse(long1 == long2);
    }

    @Test
    public void compareWrappersDouble() {
        Double double1 = 12.5;
        Double double2 = 12.5;
        Assertions.assertFalse(double1 == double2);

        double1 = 150.0;
        double2 = 150.0;
        Assertions.assertFalse(double1 == double2);
    }

    @Test
    public void compareWrappersFloat() {
        Float float1 = 12.5f;
        Float float2 = 12.5f;
        Assertions.assertFalse(float1 == float2);

        float1 = 150.0f;
        float2 = 150.0f;
        Assertions.assertFalse(float1 == float2);
    }

    @Test
    public void boxing() {
        int primitive = 10;
        Integer wrapper = primitive;
        Assertions.assertEquals(primitive,wrapper);
    }

    @Test
    public void unboxing() {
        Integer wrapper = 20;
        int primitive = wrapper;
        Assertions.assertEquals(wrapper,primitive);
    }
}
