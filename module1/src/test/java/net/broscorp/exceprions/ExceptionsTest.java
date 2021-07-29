package net.broscorp.exceprions;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import net.broscorp.exceptions.MyException;

import org.junit.jupiter.api.Test;


public class ExceptionsTest {

  @Test
  void tes1() {

    try (BufferedReader br = new BufferedReader(new FileReader("Aloha"))) {
      br.readLine();
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
