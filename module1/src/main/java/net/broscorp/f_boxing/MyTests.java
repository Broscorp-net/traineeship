import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {

    @Test
    public void integerWrappingsEqualityIsFalse() {
        Integer value1 = new Integer(10);
        Integer value2 = new Integer(10);

        assertFalse(value1 == value2,
                "10 and 10 wrappings are not equal by ==");
    }

    @Test
    public void integerValueAndWrappingNotSame() {
        int value1 = 10;
        Integer value2 = new Integer(value1);

        assertNotSame(value1, value2,
                "int and wrapped int (Integer) with the same value are not THE SAME");
    }

    @Test
    public void integerWrappingAndUnwrappedValueNotSame() {
        Integer value1 = new Integer(10);
        int value2 = value1.intValue();

        assertNotSame(value1, value2,
                "Integer and unwrapped Integer (int) with the same value are not THE SAME");
    }
}
