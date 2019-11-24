import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTests {

    private static MathOperation addition;
    
    @BeforeAll
    public static void initTester() {
        addition = new Addition();
    }

    @Test
    public void operationWithInteger() {
        assertEquals(2 + 2, addition.operation(2, 2));
    }

    @Test
    public void operationWithIntegerWrapper() {
         assertEquals(new Integer(2) + new Integer(2),
                 addition.operation(new Integer(2), new Integer(2)));
    }

    @Test
    public void operationWithDouble() {
         assertEquals(2d + 2d, addition.operation(2d, 2d));
    }

    @Test
    public void operationWithDoubleWrapper() {
         assertEquals(new Double(2d) + new Double(2d),
                 addition.operation(new Double(2d), new Double(2d)));
    }

    /*  Ошибка при компиляции

        Ambiguous method call. Both
        operation(double, double) and
        operation(Double, Double) match.

    @Test
    public void operationWithDoubleAndDoubleWrapper() {
        assertEquals(2d + new Double(2d),
                addition.operation(2d, new Double(2d)));
    }*/
}
