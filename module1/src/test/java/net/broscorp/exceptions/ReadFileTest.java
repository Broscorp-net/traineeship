package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadFileTest {

  @Test
  public void testReadFileCatchIOException() {
    String exMessage = null;
    String expectedResult = "file.txt (The system cannot find the file specified)";

    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
      String data = reader.readLine();
      // do something
    } catch (IOException ex) {
      exMessage = ex.getMessage();
    } finally {
      System.out.println("Oops... Goodbye!");
    }

    Assertions.assertNotNull(exMessage);
    Assertions.assertEquals(expectedResult, exMessage);
  }

  @Test
  public void testReadFileCatchFileNotFoundException() {
    String exMessage = null;
    String expectedResult = "file.txt (The system cannot find the file specified)";

    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
      String data = reader.readLine();
      // do something
    } catch (FileNotFoundException ex) {
      exMessage = ex.getMessage();
    } catch (IOException ex) {
      exMessage = "Wrong catch clause";
    } finally {
      System.out.println("Oops... Goodbye!");
    }

    Assertions.assertNotNull(exMessage);
    Assertions.assertEquals(expectedResult, exMessage);
  }
}
