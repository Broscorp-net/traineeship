package net.broscorp.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class содержит методы для тестированя методов класса PrimitiveTypes
 *
 * @author Volodymyr Lopachak
 * @version 1.0
 */
class PrimitiveTypesTest {

  private static PrimitiveTypes primitiveTypes;

  @BeforeAll
  static void beforeAll() {
        primitiveTypes = new PrimitiveTypes();
    }

  @Test
  void testOverflow() {
        Assertions.assertEquals(-116, primitiveTypes.overflow());
    }

  @Test
  void testLongTransformation() {
        Assertions.assertEquals(525_163_520, primitiveTypes.longTransformation());
    }

  @Test
  void testDoubleTruncation() {
    Assertions.assertEquals(56, primitiveTypes.doubleTruncation());
  }

  @Test
  void testDoubleTransformationOne () {
    double expected = 99_999_999.33333333;
    Assertions.assertNotEquals(expected, primitiveTypes.doubleTransformation(expected));
  }

  @Test
  void testDoubleTransformationTwo () {
    double expected = 98_888_888.33333333;
    Assertions.assertNotEquals(expected, primitiveTypes.doubleTransformation(expected));
  }

  @Test
  void testFloatingPointNumbers () {
    float f1 = 0.3F;
    float f2 = 0.4F;
    float f3 = 0.7F;

    Assertions.assertNotEquals(true, primitiveTypes.floatingPointNumbers(f1, f2, f3));
  }

  @Test
  void testDoubleSum () {
    double d1 = 2.0;
    double d2 = 1.1;
    Assertions.assertNotEquals(0.9, primitiveTypes.doubleSum(d1, d2));
  }

  @Test
  void testLoopDoubleSum () {
    double expected = 1.0;
    Assertions.assertNotEquals(expected, primitiveTypes.loopDoubleSum());
  }

  @Test
  void testLoopFloatSum () {
    float expected = 1.0F;
    Assertions.assertNotEquals(expected, primitiveTypes.loopFloatSum());
  }

}