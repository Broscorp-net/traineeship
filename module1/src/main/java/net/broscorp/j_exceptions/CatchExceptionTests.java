import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatchExceptionTests {

    private static CatchExceptionMethods tester;
    private static String fileName;

    @BeforeAll
    public static void initTestObject() {
        tester = new CatchExceptionMethods();
        fileName = "exception.dot";
    }

    @Test
    public void whenCatchIOException_thenAssertionSucceeds() {
        assertDoesNotThrow(() -> {
            tester.readFile_catchesIOException(fileName);
        });
    }

    @Test
    public void whenCatchException_thenAssertionSucceeds() {
        assertDoesNotThrow(() -> {
            tester.readFile_catchesException(fileName);
        });
    }

    @Test
    public void whenCatchThrowable_thenAssertionSucceeds() {
        assertDoesNotThrow(() -> {
            tester.readFile_catchesThrowable(fileName);
        });
    }


}
