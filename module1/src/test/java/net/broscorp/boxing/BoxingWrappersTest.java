package net.broscorp.boxing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class тестирует методы класса BoxingWrappers
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
class BoxingWrappersTest {
    private static BoxingWrappers boxingWrappers;
    // переменная для передачи в метод и получения ошибки
    private static Double data;

    @BeforeAll
    public static void init() {
        boxingWrappers = new BoxingWrappers();
    }

    @Test
    public void testComparisonInteger() {
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(10);

        assertEquals(true, boxingWrappers.comparisonInteger(i1, i2), "equals");
    }

    @Test
    public void testComparisonFloatOne() {
        Float f1 = new Float(10.F);
        Float f2 = new Float(10.F);

        assertEquals(false, boxingWrappers.comparisonFloat(f1, f2), "NOT equals");
    }

    @Test
    public void testComparisonFloatTwo() {
        Float f1;
        Float f2;
        float f1_1 = 2F;
        float f2_2 = 2F;
        f1 = f1_1;
        f2 = f2_2;

        assertEquals(false, boxingWrappers.comparisonFloat(f1, f2), "NOT equals");
    }

    @Test
    public void testAppropriation() {
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            boxingWrappers.appropriation(data);
        });
        System.out.println(thrown.getMessage());
    }

}