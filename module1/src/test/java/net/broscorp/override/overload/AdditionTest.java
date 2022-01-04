package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionTest {

  Addition add = new Addition();

  @Test
  void doubleTest() {
    Assertions.assertEquals(add.mathOp(4.0,4.0),8);
  }

  @Test
  void intTest() {
    Assertions.assertEquals(add.mathOp(4,4),8);
  }

  @Test
  void wrapDoubleTest() {
    Assertions.assertEquals(add.mathOp(new Double(4),new Double(4)),8);
  }
}
