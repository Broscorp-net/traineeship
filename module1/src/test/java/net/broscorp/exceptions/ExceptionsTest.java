package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ExceptionsTest {

  @Test
  void shouldHandleFileNotFoundException() {
    handleExceptions("NoFile.txt");
  }

  @Test
  void shouldHandleIoException() {
    handleExceptions("src\\main\\java\\net\\broscorp\\exceptions\\file.txt");
  }

  private void handleExceptions(String path) {
    String text = "";
    try (BufferedReader bufferedReader = new BufferedReader(
        new FileReader(path))) {
      text = bufferedReader.readLine();
      if (text == null || text.isEmpty()) {
        throw new IOException("Input file has no contents");
      }
    } catch (FileNotFoundException fnf) {
      System.out.println("File not found");
    } catch (IOException io) {
      System.out.println(io.getMessage());
    } finally {
      System.out.println("FileNotFoundException handled. Bye!");
    }
  }
}