import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTests {

    private static MathOperation multiplication;
    
    @BeforeAll
    public static void initTester() {
        multiplication = new Multiplication();
    }

    @Test
    public void operationWithInteger() {
        assertEquals(2 * 2, multiplication.operation(2, 2));
    }

    @Test
    public void operationWithIntegerWrapper() {
         assertEquals(new Integer(2) * new Integer(2),
                 multiplication.operation(new Integer(2), new Integer(2)));
    }

    /*  Ошибка при компиляции

        Ambiguous method call. Both
        operation(int, int) and
        operation(Integer, Integer) match.

    @Test
    public void operationWithIntAndIntegerWrapper() {
        assertEquals(2 * new Integer(2),
                multiplication.operation(2, new Integer(2)));
    }
     */

    @Test
    public void operationWithDouble() {
         assertEquals(2d * 2d, multiplication.operation(2d, 2d));
    }

    @Test
    public void operationWithDoubleWrapper() {
         assertEquals(new Double(2d) * new Double(2d),
                 multiplication.operation(new Double(2d), new Double(2d)));
    }

}
