package net.broscorp.j_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {

  public void finallyBlockExecution(String fileTap) {
    try (BufferedReader bReader = new BufferedReader(new FileReader(fileTap))) {
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Goodbay!!");
    }
  }

  public void arithmeticException() {
    try {
      @SuppressWarnings("unused")
      int c = 10 / 0;
    } catch (ArithmeticException e) {
      e.printStackTrace();
    }
  }

  public void predecessorException() {
    try {
      int[] array = {0, 1};
      @SuppressWarnings("unused")
      int b = array[2];
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public void pedecessorThrowable() {
    try {
      Object obj = null;
      obj.toString();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
