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
  public void convertTestInts() {
    long someLongNumber = 1000000000000000L;
    Assertions.assertTrue((int) someLongNumber < 0);
  }

  @Test
  public void convertTestFloat() {
    double someDoubleNumber = 100000000000000000000000.1234567891011;
    Assertions.assertNotEquals(someDoubleNumber, (float) someDoubleNumber);
  }

  @Test
  public void arithmeticalOperationsWithFloats() {
    double f1 = 0.0;

    for (int i = 1; i <= 11; i++) {
      f1 += .1;
    }

    double f2 = 0.1 * 11;

    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);

    Assertions.assertNotEquals(f1, f2);
  }

  @Test
  public void accuracyTest() {
    System.out.println("float of 2.121313241412441124: " + 2.121313241412441124f);
    System.out.println("double of 2.121313241412441124: " + 2.121313241412441124d);

    Assertions.assertNotEquals(2.121313241412441124f, 2.121313241412441124d);
  }
}
