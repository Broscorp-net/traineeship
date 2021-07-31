package net.broscorp.override.overload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class MathAdditionTest {

  @Test
  void method() {
    MathAddition math = new MathAddition();

    double x = math.doCalc(0.1, 0.2);

    assertEquals(0.300001, x, 0.00001);
  }

  @Test
  void testMethod() {
    MathAddition math = new MathAddition();

    double x = math.doCalc(10, 10);

    assertEquals(20, x);
  }

  @Test
  void testMethod1() {
    MathAddition math = new MathAddition();

    Integer y = 1;
    Integer z = 2;

    double x = math.doCalc(z, y);

    assertEquals(3, x);
  }

  @Test
  void testMethod2() {
    MathAddition math = new MathAddition();

    Double y = 1.1;
    Double z = 2.2;

    double x = math.doCalc(z, y);

    assertEquals(3.3, x, 0.00000001);
  }

  /**
   * Java compiler can't select proper method because of ambiguous method call (int,int vs
   * Integer,Integer).
   */
  @Test
  @Disabled
  void testMethod3() {
    MathAddition math = new MathAddition();

    Integer y = 2;
    int z = 1;

    //        double x = math.doCalc(y, z);
  }
}
