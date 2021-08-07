package net.broscorp.exceptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

  @Test
  public void tryWithResourcesTest() {
    assertTrue(() -> {
      try (BufferedReader br = new BufferedReader(new FileReader("unexistingfile"))) {
        br.readLine();
      } catch (FileNotFoundException e) {
        System.out.println("File was not found.");
        return true;
      } catch (IOException e) {
        System.out.println("Unexpected problem occurred with reading file.");
      } finally {
        System.out.println("Shutting down");
      }
      return false;
    });

  }

}
