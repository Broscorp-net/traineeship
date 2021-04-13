//import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimitivesTest {

  @Test
  public void owerflowTest() {
    byte a = 127;
    byte b = (byte)(a + 1);
    Assertions.assertEquals(Byte.MIN_VALUE,b);
  }

  @Test
  public void longToIntTest() {
    long a = Long.MAX_VALUE;
    int  b = (int)a;
    Assertions.assertTrue(b < 0);
  }

  @Test
  public void floatToDoubleTest() {
    float f = 0.1f;
    double d = (double)f;
    Assertions.assertEquals(d,f);
  }

  @Test
  public void floatDoubleProblemsTest() {
    float a = 100.55f;
    double b = 100.0;
    Assertions.assertNotEquals(0.55, a - b);
  }
}