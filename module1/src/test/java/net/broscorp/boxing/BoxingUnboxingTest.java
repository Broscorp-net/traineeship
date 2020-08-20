package net.broscorp.boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BoxingUnboxingTest {

  @Test
  public void testAutoBoxingIntegers() {
    int a = 1;
    List<Integer> list = new ArrayList<>();
    list.add(a);
    assertEquals(1, list.get(0));
  }

  @Test
  public void testUnBoxingIntegers() {
    Integer a = 100;
    Integer b = 200;

    int result = a + b;
    assertEquals(300, result);
  }


}
