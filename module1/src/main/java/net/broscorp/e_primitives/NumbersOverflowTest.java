import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumbersOverflowTest {

  @Test
  public void shouldAnalyseByteOverflow() {
    NumbersOverflow example = new NumbersOverflow();
    byte result = example.ByteOverflow();
    assertEquals(-128, result);
  }

  @Test
  public void shouldAnalyseShortOverflow() {
    NumbersOverflow example = new NumbersOverflow();
    short result = example.ShortOverflow();
    assertEquals(-32768, result);
  }


  @Test
  public void shouldAnalyseIntegerOverflow() {
    NumbersOverflow example = new NumbersOverflow();
    int result = example.IntegerOverflow();
    assertEquals(-2147483648, result);
  }

  @Test
  public void shouldAnalyseLongOverflow() {
    NumbersOverflow example = new NumbersOverflow();
    long result = example.LongOverflow();
    assertEquals(-9223372036854775808L, result);
  }

  @Test
  public void shouldAnalyseFloatOverflow() {
    NumbersOverflow example = new NumbersOverflow();
    float result = example.FloatOverflow();
    assertEquals(3.4028235E38, result);

  }

  @Test
  public void shouldAnalyseDoubleOverflow() {
    NumbersOverflow example = new NumbersOverflow();
    double result = example.DoubleOverflow();
    assertEquals(1.7976931348623157E308, result);
  }

  @Test
  public void shouldAnalysePrimitivesConversion() {
    NumbersOverflow example = new NumbersOverflow();
    int result = example.PrimitivesConversion();
    assertEquals(15, result);
  }

  @Test
  public void shouldAnalyseFloatNumbersConversion() {
    NumbersOverflow example = new NumbersOverflow();
    int result = example.FloatNumbersConversion();
    assertEquals(10, result);
  }
}