package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  public void intOverflowTest() {
    Assertions.assertThrows(
        ArithmeticException.class,
        () -> {
          int max = Math.addExact(Integer.MAX_VALUE, Integer.MAX_VALUE);
        });
  }

  @Test
  public void convertTest() {
    long someLongNumber = 1000000000000000L;
    System.out.println("long value :" + someLongNumber);
    System.out.println("long value after casting to int: " + (int) someLongNumber);

    double someDoubleNumber = 100000000000000000000000.1234567891011;
    System.out.println("double value :" + someDoubleNumber);
    System.out.println("double value after casting to float: " + (float) someDoubleNumber);
  }

  @Test
  public void accuracyTest() {
    System.out.println("float of 2.121313241412441124: " + 2.121313241412441124f);
    System.out.println("double of 2.121313241412441124: " + 2.121313241412441124d);
  }
}
