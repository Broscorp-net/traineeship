package primitives;

import static org.junit.jupiter.api.Assertions.*;

import net.broscorp.primitives.conversion.Conversion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConversionTest {

  private Conversion conversion;

  @BeforeEach
  void init() {
    conversion = new Conversion();
  }

  @Test
  void shouldConvertLongToInt() {
    assertEquals(34299, conversion.longToInt(34299L));
  }

  @Test
  void shouldConvertLongToIntIfLongVeryBig() {
    assertEquals(124048589, conversion.longToInt(34299732874445L));
  }

  @Test
  void shouldCcnvertDoubleToFloat() {
    assertEquals(345.90f, conversion.doubleToFloat(345.90d));
  }

  @Test
  void shouldConvertDoubleToFloatIfDoubleBig() {
    assertEquals(345.90787f, conversion.doubleToFloat(345.90787463654347835734345d));
  }
}