package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList<Integer> myCoolListInteger;

  @BeforeEach
  void setUp() {
    myCoolListInteger = new MyCoolList<>();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  @DisplayName("Should add element in list")
  void shouldAddElementToList() {
    final int expectedInteger = 3;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(8);

    final int actualInteger = myCoolListInteger.size();

    assertEquals(expectedInteger, actualInteger);

    MyCoolList<Float> myCoolListFloat = new MyCoolList<>();
    final int expectedFloat = 3;
    myCoolListFloat.add(5.7F);
    myCoolListFloat.add(new Float(10.9F));
    myCoolListFloat.add(8F);

    final int actualFloat = myCoolListFloat.size();

    assertEquals(expectedFloat, actualFloat);

  }

  @Test
  @DisplayName("Should get element from list")
  void shouldGetElementFromList() {
    final int expected = 7;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    final int actual = myCoolListInteger.get(3);

    assertEquals(expected, actual);

  }

  @Test
  @DisplayName("Should remove element from list")
  void shouldRemoveElementFromList() {
    final int expectedElement = 7;
    final int expectedSize = 3;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    final int actualElement = myCoolListInteger.remove(3);
    final int actualSize = myCoolListInteger.size();

    assertEquals(expectedElement, actualElement);
    assertEquals(expectedSize, actualSize);

  }

  @Test
  @DisplayName("Should return the changed object")
  void shouldMap() {
    final int expectedValue = 9;
    final int expectedSize = 4;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    myCoolListInteger.map((x) -> Math.decrementExact(x));

    final int actualValue = myCoolListInteger.get(1);
    final int actualSize = myCoolListInteger.size();

    assertEquals(9, actualValue);
    assertEquals(4, actualSize);

  }

  @Test
  @DisplayName("Should return the number elements in the list")
  void shouldReturnSizeList() {
    final int expectedZeroSize = 0;
    final int expectedAddSize = 4;
    final int expectedRemoveSize = 3;

    final int actualZeroSize = myCoolListInteger.size();
    assertEquals(expectedZeroSize, actualZeroSize);

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    final int actualAddSize = myCoolListInteger.size();
    assertEquals(expectedAddSize, actualAddSize);

    myCoolListInteger.remove(3);
    final int actualRemoveSize = myCoolListInteger.size();
    assertEquals(expectedRemoveSize, actualRemoveSize);

  }
}