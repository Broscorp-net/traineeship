package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {

  Multiplication mult = new Multiplication();

  @Test
  void doubleTest() {
    Assertions.assertEquals(mult.mathOp(4.0,4.0),16);
  }

  @Test
  void intTest() {
    Assertions.assertEquals(mult.mathOp(4,4),16);
  }

  @Test
  void wrapDoubleTest() {
    Assertions.assertEquals(mult.mathOp(new Double(4),new Double(4)),16);
  }
}
