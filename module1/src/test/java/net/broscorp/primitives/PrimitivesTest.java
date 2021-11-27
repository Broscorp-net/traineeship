package net.broscorp.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PrimitivesTest {

  Primitives primitives;

  @BeforeEach
  void setUp() {
    primitives = new Primitives();
  }


  @Test
  void add() {
    int  expected = -2147483648;
    int result = primitives.add(2147483647,1);
    assertEquals(expected,result);
  }



  @Test
  void testAdd() {
    int  expected = 10;
    int result = primitives.add(5,5);
    assertEquals(expected,result);
  }

  @Test
  void conversion() {
    int expected = -1802338305;
    int result = primitives.conversion(372036854775807L);
    assertEquals(expected, result);
  }

  @Test
  void conversionContinuous() {
    int expected2 = 100;
    int result2 = primitives.conversion(100L);
    assertEquals(expected2, result2);
  }

  @Test
  void conversion2() {
    double expected = 3.720_368_623_733_520_5;
    double result = primitives.conversion2(3.720_368_547_758_071_11f);
    assertEquals(expected,result);
  }

  @Test
  void count() {
    double expected = 0.10000000000000007;
    double result = primitives.count(100);
    assertEquals(expected,result);
  }
}
