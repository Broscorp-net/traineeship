package net.broscorp.exceptions;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class демонстрирует получение и перехват исключений
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
class ExceptionTest {

    /**
     * Класс демонстрирует создание исключения, его обработку и выполнение блока finally
     */
    @Test
    public void testIOException() {
        final String wrongPatch = "C:/files/test.txt";

        try (FileReader reader = new FileReader(wrongPatch)) {
            // some code here
        } catch (IOException e) {
            System.out.println("CATCH EXCEPTION ");
        } finally {
            System.out.println("FINALLY on the TestIOException");
        }
    }

    /**
     * Класс демонстрирует перехват исключения и вызов его причины
     */
    @Test
    public void testChainException() {
        try {
            createException();
        } catch (NullPointerException e) {
            System.out.println("Catch exceptions " + e.getMessage());
            System.out.println("Cause exceptions " + e.getCause().getMessage());
        }
    }

    /**
     * Класс создаёт 2 тсключения, вложенные одно в другое
     */
    private void createException() {
        NullPointerException nullPointerException = new NullPointerException("UPPER LEVEL");
        nullPointerException.initCause(new ArithmeticException("CAUSE"));
        throw nullPointerException;
    }

}