package net.broscorp.exceptions;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

  private static void readFileIOException() {
    try (FileReader reader = new FileReader("")) {

    } catch (IOException e) {
      System.out.println("Excption catched");
    } finally {
      System.out.println("Good bye!");
    }
  }

  private static void readFileException() {
    try (FileReader reader = new FileReader("")) {

    } catch (Exception e) {
      System.out.println("Excption catched");
    } finally {
      System.out.println("Good bye!");
    }
  }

  public static void main(String[] args) {
    readFileIOException();
  }
}
