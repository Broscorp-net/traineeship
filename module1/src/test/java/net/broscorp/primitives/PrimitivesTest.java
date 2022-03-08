package test.java.net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void integerOverflowTest() {
    int value = Integer.MAX_VALUE + 1;
    assertEquals(Integer.MIN_VALUE, value);
  }

  @Test
  public void longToIntegerCastingTest() {
    long big = Long.MAX_VALUE;
    int smol = (int) big;
    assertNotEquals(smol, big);
  }

  @Test
  public void floatToDoubleCastingTest() {
    //5.5532
    float smol = 5.5532f;
    //5.553199768066406
    double big = smol;
    assertNotEquals(Float.toString(smol), Double.toString(big));
  }

  @Test
  public void doubleToFloatCastingTest() {
    double big = 5.23523423402034023;
    float smol = (float) big;
    // <5.235234260559082> vs <5.23523423402034>
    assertNotEquals(smol, big);
  }

  @Test
  public void floatingPointPrecisionProblemTest() {
    double firstVisaCard = 50.5;
    double secondVisaCard = 50.0 + 0.1 + 0.1 + 0.2 + 0.1;
    // <50.5> vs <50.50000000000001>
    assertNotEquals(firstVisaCard, secondVisaCard);
  }
}
