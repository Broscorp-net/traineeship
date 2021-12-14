package net.broscorp.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

  @Test
  void openFileThrowException() {
    try {
      new Scanner(new File("D:\\work\\example\\text.txt"));
    } catch (FileNotFoundException exception){
      System.out.println("IOException => " + exception);
    } finally {
      System.out.println("Bye from finally, bcs file not found");
    }
  }

  @Test
  void catchParentExceptionThrowException() {
    try {
      System.out.print("do something and then generate exception");
      throw new Exception();
    } catch (Exception e) {
      System.out.print("exception " + e);
    }
  }
}
