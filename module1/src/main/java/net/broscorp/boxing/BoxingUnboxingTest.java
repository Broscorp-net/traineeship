package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BoxingUnboxingTest {

  @Test
  public void boxingTest() {
    int number = 1;
    List<Integer> list = new ArrayList<>();
    list.add(number);
    assertEquals(1, list.get(number));
  }

  @Test
  public void unboxingTest() {
    Integer firstNumber = 5;
    Integer secondNumber = 5;

    int resultOfConcat = firstNumber + secondNumber;
    assertEquals(10, resultOfConcat);
  }

}
