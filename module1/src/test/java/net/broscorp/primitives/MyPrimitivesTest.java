package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MyPrimitivesTest {

  //numeric type overflow tests
  @Test
  void intOverflowIncrementationTest() {
    int a = Integer.MAX_VALUE;
    assertEquals(Integer.MIN_VALUE, ++a);
  }

  @Test
  void intOverflowMultiplicationTest() {
    int a = 2_000_000;
    int b = 2_000_000;
    int c = a * b;

    assertNotEquals(4_000_000_000_000L, c);
    assertEquals(1385447424, c);
  }

  //conversion problems between primitive types test
  @Test
  void longToIntConversionProblemTest() {
    long a = 2_000_000_000_000L;
    int b = (int) a;

    assertNotEquals(2_000_000_000_000L, b);
    assertEquals(-1454759936, b);
  }

  //floating point error test
  @Test
  void floatingPointErrorTest() {
    float a = 10;

    float adiv = a / 3; //expected result 3.3333333333333333, but actual result 3.3333332538604736

    assertEquals(3.3333332538604736, adiv, 0);
  }

}
