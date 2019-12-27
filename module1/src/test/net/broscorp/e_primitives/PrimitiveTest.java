package net.broscorp.e_primitives;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrimitiveTest {

    @Test
    void overflowByteAddition() {
        byte b = Byte.MAX_VALUE;
        byte result = ++b;
        assertEquals(-128, result);
    }

    @Test
    void overflowShortAddition() {
        short s = Short.MAX_VALUE;
        short result = ++s;
        assertEquals(-32768, result);
    }

    @Test
    void overflowIntAddition() {
        int i = Integer.MAX_VALUE;
        int result = ++i;
        assertEquals(-2147483648, result);
    }

    @Test
    void overflowFloatAddition() {
        float f = Float.MAX_VALUE;
        float result = f + 0.34e39F; // при переполнении, float присваивается "Бесконечность"
        assertEquals(Infinity, result);
    }

    /**
     * Теряется точность при сужении численного типа, т. к. "отбрасываются лишние" биты и происходит переполнение
     */
    @Test
    void convertLongToInt() {
        long l = Integer.MAX_VALUE + 1L;
        int i = (int) l; // теряется единица
        assertEquals(-2147483648, i);
    }

    /**
     * При расширении типа точность остается прежней
     */
    @Test
    void convertFloatToDouble() {
        float f = Float.MAX_VALUE;
        f += Float.MAX_VALUE;
        double d = f;
        assertEquals(d, f);
    }

    /**
     * Тестируя числовые значения с плавающей запятой, сталкиваемся с
     * нарушением точности вычислений. Решение этой проблемы:
     *  - модификатор strictfp;
     *  - BigInteger (для целочисленных данных) и BigDecimal (для чисел с плавающей точкой).
     */
    @Test
    void inaccuracyFloat() {
        float f1 = 0.6f;
        float f2 = 0.3f;
        float result = f1 + f2;
        assertNotEquals(0.9f, result);
    }

    @Test
    void inaccuracyDouble() {
        double f1 = 0.6;
        double f2 = 0.3;
        double result = f1 + f2;
        assertNotEquals(0.9, result);
    }

}