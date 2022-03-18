package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathOperationTest {
  MathOperation operation;
  @Test
  void addTest() {
    operation = new MathOperationAdd();
    Assertions.assertEquals(4.0, operation.mathOperation(2,2));
    Assertions.assertEquals(4.0, operation.mathOperation(new Integer(2), new Integer(2)));
    Assertions.assertEquals(4.0, operation.mathOperation(2.0,2.0));
    Assertions.assertEquals(4.0, operation.mathOperation(new Double(2), new Double(2)));
  }

  @Test
  void multipleTest() {
    operation = new MathOperationMultiple();
    Assertions.assertEquals(4.0, operation.mathOperation(2,2));
    Assertions.assertEquals(4.0, operation.mathOperation(new Integer(2), new Integer(2)));
    Assertions.assertEquals(4.0, operation.mathOperation(2.0,2.0));
    Assertions.assertEquals(4.0, operation.mathOperation(new Double(2), new Double(2)));
  }

  @Test
  void primitiveWrapTest() {
    /*java: reference to mathOperation is ambiguous
    both method mathOperation(int,int) in net.broscorp.override.overload.MathOperation and method
    mathOperation(java.lang.Integer,java.lang.Integer)
    in net.broscorp.override.overload.MathOperation match
    */
   // Assertions.assertEquals(4.0, operation.mathOperation(2 , Integer.valueOf(2)));
  }
}
