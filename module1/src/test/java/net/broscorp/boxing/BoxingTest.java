package net.broscorp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BoxingTest {
  @Test
  void compareForTrueTest() {
  Integer a = 100;
  Integer b = 100;
  assertTrue(a==b,true);
  }

  @Test
  void compareForFalseOneTest() {
  Integer a = 200;
  Integer b = 200;
  assertFalse(a==b,false);
  }

  @Test
  void compareForFalseTwoTest() {
  Integer a = new Integer(100);
  Integer b = new Integer(100);
  assertFalse(a==b,false);
  }

  @Test
  void unboxingExceptionTest() {
  Integer a = null;
  int b = a;
  }
}