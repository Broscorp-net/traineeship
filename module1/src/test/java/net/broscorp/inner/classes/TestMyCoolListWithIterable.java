package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyCoolListWithIterable {

  private MyCoolList<Integer> integerList = new MyCoolList<>(0);

  @BeforeEach
  public void init() {
    integerList.add(12);
  }

  @Test
  public void addToList() {
    integerList.add(47);
    int expectedSize = 2;
    assertEquals(expectedSize, integerList.size());
  }

  @Test
  public void removeFromList() {
    integerList.add(41);
    integerList.remove(0);
    int expectedSize = 1;
    assertEquals(expectedSize, integerList.size());
  }

  @Test
  public void getElementByIndexFromList() {
    assertEquals(12, integerList.get(0));
  }

  @Test
  public void getFailIndex() {
    assertThrows(RuntimeException.class, () -> {
      integerList.get(integerList.size() + 1);
    });
  }

  @Test
  public void getSizeFromList() {
    integerList.add(18);
    integerList.add(116);
    integerList.add(1144);
    assertEquals(4, integerList.size());
  }

  @Test
  public void mapFromIntegerToDoubleList() {
    integerList.add(78);
    integerList.add(8);
    integerList.add(38);
    Function<Integer, Double> intToDouble = integer -> integer.doubleValue();
    MyCoolList<Double> doubleList = integerList.map(intToDouble);
    System.out.println(doubleList.showList());
    String expectedArray = "[12.0, 78.0, 8.0, 38.0]";
    assertEquals(expectedArray, doubleList.showList());
  }

  @Test
  public void testMyIterableMethodHasNextTrue() {
    assertTrue(integerList.iterator().hasNext());
  }

  @Test
  public void testMyIterableMethodHasNextFalse() {
    integerList.remove(0);
    assertFalse(integerList.iterator().hasNext());
  }

  @Test
  public void testMyIterableMethodNext() {
    integerList.add(78);
    MyCoolList<Integer> integerTest = new MyCoolList<>(10);
    while (integerList.iterator().hasNext()) {
      integerTest.add(integerList.iterator().next());
    }
    assertEquals(12, integerTest.get(0));
    assertEquals(78, integerTest.get(1));
  }
}
