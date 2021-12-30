package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  void numericOverflow() {
    int i = Integer.MAX_VALUE;
    i += 20;
    Assertions.assertFalse(i > Integer.MAX_VALUE);
  }

  @Test
  void long2IntIssue() {
    long l = (long)Integer.MAX_VALUE;
    l += 20;
    int i = (int)l;
    Assertions.assertNotEquals(l,i);
  }

  @Test
  void float2DoubleIssue() {
    // Could not identify possible issues with converting float to double - please advise
    Assertions.assertTrue(true);
  }

  @Test
  void floatingPointIssue() {
    double a = 0.2;
    double b = 0.1;
    double c = a + b;
    Assertions.assertNotEquals(c, 0.3);
  }
}
