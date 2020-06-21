package net.broscorp.j_exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExampleOfException {

    @Test
    public void readFileGetIOExceptionAndSayGoodbyeInFinally() {
        assertEquals("Oops, sometime happen...", readFileWithException());
    }

    @Test
    public void catchAncestorsOfExceptions(){
        assertThrows(FileNotFoundException.class, () -> {
            try (FileReader reader = new FileReader("someText.txt")) {
                System.out.println(reader.toString());
            } catch (FileNotFoundException ex) {
                throw new FileNotFoundException("Not found");
            } catch (IOException ex) {
                throw new IOException(ex.getMessage());
            }
        });
    }

    private String readFileWithException() {
        try (FileReader reader = new FileReader("someText.txt")) {
            return reader.toString();
        } catch (IOException ex) {
            throw new IOException(ex.getMessage());
        } finally {
            return "Oops, sometime happen...";
        }
    }
}
