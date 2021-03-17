import org.junit.Assert;
import org.junit.Test;


public class PrimitivesTest {

  @Test
  public void byteOverflowTest() {
    short a = (short) 32767;
    short b = (short) (a + 1);
    Assert.assertTrue(b < a);
  }

  @Test
  public void longToIntConversionProblemTest() {
    long number = Long.MAX_VALUE;
    System.out.println((int) number);
    Assert.assertEquals(-1, (int) number);
  }

  @Test
  public void longToIntConversionTest() {
    long number = 500000;
    System.out.println((int) number);
    Assert.assertEquals(500000, (int) number);
  }

  @Test
  public void floatDouble() {
    float number = 14.1F;
    double numberB = number;
    System.out.println((double) number);
    Assert.assertNotEquals(14.1, numberB);
  }

  @Test
  public void doubleFloatDefectTest() {
    float a = 13.33f;
    double b = 13.0;
    Assert.assertNotEquals(0.33, a - b);
  }
}
