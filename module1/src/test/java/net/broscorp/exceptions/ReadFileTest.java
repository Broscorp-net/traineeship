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
    String expectedResult = "File not found found";

    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
      String data = reader.readLine();
      // do something
    } catch (IOException ex) {
      exMessage = "File not found found";
    } finally {
      System.out.println("Oops... Goodbye!");
    }

    Assertions.assertNotNull(exMessage);
    Assertions.assertEquals(expectedResult, exMessage);
  }

  @Test
  public void testReadFileCatchFileNotFoundException() {
    String exMessage = null;
    String expectedResult = "File not found found";

    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
      String data = reader.readLine();
      // do something
    } catch (FileNotFoundException ex) {
      exMessage = "File not found found";
    } catch (IOException ex) {
      exMessage = "Wrong catch clause";
    } finally {
      System.out.println("Oops... Goodbye!");
    }

    Assertions.assertNotNull(exMessage);
    Assertions.assertEquals(expectedResult, exMessage);
  }
}
