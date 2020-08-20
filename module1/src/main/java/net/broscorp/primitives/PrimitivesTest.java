import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrimitivesTest {

  @Test
  public void numericOverflowShouldAppear() {
    byte byteNumber = (byte) 128;
    assertEquals(-128, byteNumber);
  }

  @Test
  public void longToIntConversion() {
    long longNumber = 25626455625454L;
    int intNumber = -1614229778;
    assertEquals(intNumber, (int) longNumber);
  }

  @Test
  public void floatToDoubleConversion() {
    float floatNumber = 2.54f;
    double doubleNumber = 2.5399999618530273;
    assertEquals(doubleNumber, (double) floatNumber);
  }

  @Test
  public void workingWithFloatingNumbersFault() {
    double doubleNumber = 0.0;

    for (int i = 0; i < 10; i++) {
      doubleNumber += 0.1;
    }
    double expectedResult = 10;
    assertNotEquals(expectedResult, doubleNumber);
  }
}