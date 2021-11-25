package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class MyClass {

  @Test
  void testOpenFileWithException() {
    String pathname = "testFile.txt";
    File file = new File(pathname);
    try (BufferedReader bfr = new BufferedReader(new FileReader(file))) {
      System.out.println(bfr.readLine());
    } catch (IOException e) {
      System.out.println("IOException found " + e.getMessage());
    } finally {
      System.out.println("Goodbye File");
    }
  }

  @Test
  void testAncestorsHandling() {
    try {
      throw new IndexOutOfBoundsException();
    } catch (RuntimeException runtimeException) {
      System.out.println("IndexOutOfBoundsException caught in RuntimeException catch block");
    }
    //    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
    //      не будет срабатывать так как предок был словлен
    //    }
  }

}
