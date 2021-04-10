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
  }

  @Test
  public void longToIntTest() {
    long a = 50500040L;
    int  b = (int)a;
    Assertions.assertEquals(b,a);
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