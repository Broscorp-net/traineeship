package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void overflowTest() {

    //variable is in positive range
    int testedVariable = 1;
    //adding positive number
    testedVariable += Integer.MAX_VALUE;

    //for some reason variable is now negative(((
    assertTrue(testedVariable < 0);

  }

  @Test
  public void failCastTest() {
    //long max value is far more than int max value
    //this operation results in overflow
    long extremelyBigLong = Long.MAX_VALUE;
    assertNotEquals(extremelyBigLong, (int) extremelyBigLong);

    //double stores the number the different way compared to float
    float pi = 3.141592F;
    assertNotEquals(Float.toString(pi), Double.toString(pi));

  }

  @Test
  public void accuracyStarvingTest() {

    double sneakyDouble = 2.0 - 1.1;
    assertNotEquals(0.9d, sneakyDouble);

    double seackyDoubleBrother = 0.0;
    for (int i = 1; i <= 10; i++) {
      seackyDoubleBrother += 0.1;
    }
    assertNotEquals(1d, seackyDoubleBrother);

  }

}
