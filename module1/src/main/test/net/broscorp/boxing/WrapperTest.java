package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class WrapperTest {

  @Test
  void comparisonIntegerInsideTheHeapTest() {
    Integer firstInteger = -128;
    Integer secondInteger = -128;
    assertSame(firstInteger, secondInteger);
  }

  @Test
  void comparisonIntegerOutsideTheHeapTest() {
    Integer firstInteger = 128;
    Integer secondInteger = 128;
    assertNotSame(firstInteger, secondInteger);
  }

  @Test
  void equalsIntegerInsideTheHeapTest() {
    Integer firstInteger = 0;
    Integer secondInteger = 0;
    assertEquals(secondInteger, firstInteger);
  }

  @Test
  void equalsIntegerOutsideTheHeapTest() {
    Integer firstInteger = 5000;
    Integer secondInteger = 5000;
    assertEquals(secondInteger, firstInteger);
  }

  @Test
  void boxingTest() {
    int intVar = 404;
    Integer firstInteger = Integer.valueOf(intVar);
    Integer secondInteger = intVar;
    assertEquals(firstInteger, secondInteger);
  }

  @Test
  void unBoxingTest() {
    Integer integer = 505;
    int intVarFirst = integer;
    int intVarSecond = integer.intValue();
    assertEquals(intVarFirst, intVarSecond);
  }
}