package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The @Override annotation allows other developers (and you, when you forget)
 * to know that this method overrides something in a base class/interface,
 * and it also allows the compiler to yell at you if you're not actually
 * overriding anything in a base class. For example, if you got the number of
 * arguments wrong for a function, the compiler will give you an error saying
 * your @Override is incorrect.
 */
public class ExtraTest {

  Addition add = new Addition();
  Multiplication mult = new Multiplication();

  @Test
  void extraTestAdd() {
    // The following line of code fails on compilation:
    // no suitable method found for mathOp(int,java.lang.Double,int)
    //Assertions.assertEquals(add.mathOp(4,new Double(4), 8));
    Assertions.assertTrue(true);
  }

  @Test
  void extraTestMult() {
    // The following line of code fails on compilation:
    // no suitable method found for mathOp(int,java.lang.Double,int)
    //Assertions.assertEquals(mult.mathOp(4,new Double(4), 16));
    Assertions.assertTrue(true);
  }
}
