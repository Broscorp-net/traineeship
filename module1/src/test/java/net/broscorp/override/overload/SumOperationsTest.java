package net.broscorp.override.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumOperationsTest {
  private MathOperations mathOperations;

  @BeforeEach
  public void setUp() {
    mathOperations = new SumOperations();
  }

  @Test
  public void doubleArgsTest() {
    Assertions.assertEquals(8.0, mathOperations.someMathOperation(5.0, 3.0));
  }

  @Test
  public void intArgsTest() {
    Assertions.assertEquals(8, mathOperations.someMathOperation(5, 3));
  }

  @Test
  public void wrappersArgsTest() {
    Assertions.assertEquals(8.0, mathOperations.someMathOperation(new Integer(3), new Integer(5)));
  }

  // никакой не вызовется, ошибка компиляци, даже если поменять местами параметры
  @Test
  public void wrapperAndPrimitiveTest() {
    int primitive = 3;
    Integer wrapper = 5;
    Assertions.assertNotEquals(primitive, wrapper);//тут например метод описан, 1 парам - примитв
    //2й - обёртка
    //Assertions.assertEquals(8.0, mathOperations.someMathOperation(wrapper, primitive));
  }
}
