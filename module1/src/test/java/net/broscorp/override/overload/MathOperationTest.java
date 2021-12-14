package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathOperationTest {

  AddOperation addOperation = new AddOperation();
  MultiplicationOperation multiplicationOperation = new MultiplicationOperation();

  @Test
  void addPrimitiveIntNumbers(){
    Assertions.assertEquals(addOperation.getMathOperation(2,8), 10);
  }

  @Test
  void multiPrimitiveIntNumbers(){
    Assertions.assertEquals(multiplicationOperation.getMathOperation(2,2), 4);
  }

  @Test
  void addPrimitiveDoubleNumbers(){
    Assertions.assertEquals(addOperation.getMathOperation(2.0, 8.0), 10.0);
  }

  @Test
  void multiPrimitiveDoubleNumbers(){
    Assertions.assertEquals(multiplicationOperation.getMathOperation(2.0, 5.0), 10.0);
  }

  @Test
  void addObjectIntegerNumbers(){
    Assertions.assertEquals(addOperation.getMathOperation(8, 4), 12);
  }

  @Test
  void multiObjectIntegerNumbers(){
    Assertions.assertEquals(multiplicationOperation.getMathOperation(7, 2), 14);
  }

  @Test
  void addObjectDoubleNumbers(){
    Assertions.assertEquals(addOperation.getMathOperation(2.0,8.0), 10.0);
  }

  @Test
  void multiObjectDoubleNumbers(){
    Assertions.assertEquals(multiplicationOperation.getMathOperation(2.0,8.0), 16.0);
  }


  @Test
  void addMathOperationWithUpcast(){
    Integer firstNumber = 5;
    int secondNumber = 8;
    Double result = addOperation.getMathOperation(firstNumber, (Integer) secondNumber);
    Assertions.assertEquals(result, firstNumber+secondNumber);
  }

  @Test
  void addMathOperationWithDowncast(){
    Integer firstNumber = 5;
    int secondNumber = 8;
    Double result = addOperation.getMathOperation((int) firstNumber, secondNumber);
    Assertions.assertEquals(result, firstNumber+secondNumber);
  }
}
