package net.broscorp.exceprions;

import net.broscorp.exceptions.MyException;

import java.io.FileReader;

import java.io.IOException;

import java.io.Reader;

import org.junit.jupiter.api.Test;


public class ExceptionsTest {

  @Test
  void tes1() {

    try (Reader reader = new FileReader("Aloha")) {
    } catch (IOException e) {
      // e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Bye! ...");
    }
  }

  @Test
  void test2() {
    try {
      throw new MyException("Hello");
    } catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }
}
