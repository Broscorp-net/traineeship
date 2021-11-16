package primitives;

import static org.junit.jupiter.api.Assertions.*;

import net.broscorp.primitives.floating.FloatingPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FloatingPointTest {

  FloatingPoint floatingPoint;

  @BeforeEach
  void init() {
    floatingPoint = new FloatingPoint();
  }

  @Test
  void errorWhenMultipleTest() {
    assertNotEquals(3.999, floatingPoint.errorWhenMultiple(1.333, 3));
  }

  @Test
  void shouldReturnDoubleInMultipleTest() {
    assertEquals(3.9989999999999997, floatingPoint.errorWhenMultiple(1.333, 3));
  }
}