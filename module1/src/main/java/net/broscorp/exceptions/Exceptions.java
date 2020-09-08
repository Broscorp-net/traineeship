package net.broscorp.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {

  /**
   * This class reads nothing, just catch exceptions.
   */
  public String readFile(File file) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      // do nothing
    } catch (FileNotFoundException ex) {
      throw new FileNotFoundException();
    } catch (IOException e) {
      throw new IOException();
    } finally {
      return "Finally here";
    }
  }

  public void throwArithmeticException() {
    throw new ArithmeticException();
  }
}
