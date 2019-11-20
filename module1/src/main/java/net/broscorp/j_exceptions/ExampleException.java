package net.broscorp.j_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExampleException {

  public static String readFile(String file) {
    String message;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      reader.readLine();
    } catch (IOException e) {
      e.getMessage();
    } finally {
      message = "Good Bye";
    }
    return message;
  }

  public static void catchStringIndexOutOfBoundsException() {
    String line = "123";
    try {
      char symbol = line.charAt(5);
    } catch (StringIndexOutOfBoundsException e) {
      e.getMessage();
    }
  }

  public static void catchIndexOutOfBoundsException() {
    String line = "123";
    try {
      char symbol = line.charAt(5);
    } catch (IndexOutOfBoundsException e) {
      e.getMessage();
    }
  }

  public static void catchRuntimeException() {
    String line = "123";
    try {
      char symbol = line.charAt(5);
    } catch (RuntimeException e) {
      e.getMessage();
    }
  }

  public static void catchException() {
    String line = "123";
    try {
      char symbol = line.charAt(5);
    } catch (Exception e) {
      e.getMessage();
    }
  }

  public static void catchThrowable() {
    String line = "123";
    try {
      char symbol = line.charAt(5);
    } catch (Throwable e) {
      e.getMessage();
    }
  }
}
