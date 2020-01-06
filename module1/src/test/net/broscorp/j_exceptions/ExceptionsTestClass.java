package net.broscorp.j_exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionsTestClass {

    ExceptionClass exceptionClass = new ExceptionClass();

    @Test
    void ioExceptionTest() {
        String fileName = "name";
        assertDoesNotThrow(() -> exceptionClass.openFile(fileName));
    }

    @Test
    void ancestorThrowableTest() {
        assertDoesNotThrow(() -> exceptionClass.methodThrowable());
    }
}
