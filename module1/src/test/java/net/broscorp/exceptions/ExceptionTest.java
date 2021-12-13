package net.broscorp.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

//1.	Написать класс теста, который воспроизводит следующие случаи:
//   - __try-with-resources__ который открывает файл, но получает __IOException__, превозмогает его и печатает прощание в __finally__.

  @Test
  void openFileThrowException() {
    try {
      Scanner scanner = new Scanner(new File("D:\\work\\example\\text.txt"));
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
