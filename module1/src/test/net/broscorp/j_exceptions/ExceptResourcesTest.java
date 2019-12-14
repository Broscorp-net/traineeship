package net.broscorp.j_exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptResourcesTest {

    ExceptResources exceptResources = new ExceptResources();
    String file = "file";

    @Test
    void catchIOException() {
        assertDoesNotThrow(() -> exceptResources.catchIOException(file));
    }

    @Test
    void catchException() {
        assertDoesNotThrow(() -> exceptResources.catchException());
    }

    @Test
    void catchThrowable() {
        assertDoesNotThrow(() -> exceptResources.catchThrowable());
    }
}