package net.broscorp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  public void tryWithResourcesException() throws IOException {
    try (FileReader fw = new FileReader("test.txt")) {
      int read = fw.read();
    } catch (FileNotFoundException ignored) {
      //перехватываем FileNotFoundException, у которого предок IOException
    } finally {
      System.out.println("bye bye");
    }
  }
}