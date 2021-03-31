package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {
  private MyCoolList<Integer> list = new MyCoolList<>();

  @BeforeEach
  void setUp() {
    list.add(1);
    list.add(2);
    list.add(3);
  }

  @Test
  void listShouldAdd() {
    list.add(4);

    assertEquals(4, list.get(3));
  }

  @Test
  void listShouldRemove() {
    list.remove(0);

    assertEquals(2, list.get(0));
  }

  @Test
  void listShouldGet() {
    assertEquals(1, list.get(0));
  }

  @Test
  void listShouldGetSize() {
    assertEquals(3, list.size());
  }

  @Test
  void listMapTypeShouldReturnDoubleList() {
    Function<Integer, Double> function = Integer::doubleValue;

    assertTrue(list.map(function).get(0) instanceof Double);
    assertTrue(list.map(function).get(1) instanceof Double);
    assertTrue(list.map(function).get(2) instanceof Double);
  }
}
