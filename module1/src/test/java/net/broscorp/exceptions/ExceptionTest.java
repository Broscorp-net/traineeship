package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

  @Test
  void openFileThrowException() {
    String filePath = "src/resources/thermopylae.txt";
    try (BufferedReader br =
        new BufferedReader(new FileReader(filePath))) {
      br.readLine();
    } catch (IOException exception){
      System.out.println("FileNotFoundException " + exception);
    } finally {
      System.out.println("Bye");
    }
  }

  @Test
  void catchParentExceptionThrowException() {
    String filePath = "src/resources/thermopylae.txt";
    try (BufferedReader br =
        new BufferedReader(new FileReader(filePath))) {
      br.readLine();
    } catch (Throwable exception){
      System.out.println("Throwable " + exception);
    }
  }
}
