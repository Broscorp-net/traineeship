package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    final int expectedAddInteger = 3;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(8);

    final int actualAddInteger = myCoolListInteger.size();

    assertEquals(expectedAddInteger, actualAddInteger);

    MyCoolList<Float> myCoolListFloat = new MyCoolList<>();
    final int expectedAddFloat = 3;

    myCoolListFloat.add(5.7F);
    myCoolListFloat.add(new Float(10.9F));
    myCoolListFloat.add(8F);

    final int actualAddFloat = myCoolListFloat.size();

    assertEquals(expectedAddFloat, actualAddFloat);

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
  @DisplayName("Should throw ArrayIndexOutOfBoundsException in get")
  void shouldThrowArrayIndexOutOfBoundsExceptionInGet() {
    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolListInteger.get(-1));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolListInteger.get(4));
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
  @DisplayName("Should throw ArrayIndexOutOfBoundsException in remove")
  void shouldThrowArrayIndexOutOfBoundsExceptionInRemove() {
    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolListInteger.remove(-1));
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> myCoolListInteger.remove(4));
  }

  @Test
  @DisplayName("Should return the changed object")
  void shouldReturnMapObject() {
    final int expectedValue = 11;
    final int expectedSize = 4;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    myCoolListInteger.map((x) -> Math.incrementExact(x));

    final int actualValue = myCoolListInteger.get(1);
    final int actualSize = myCoolListInteger.size();

    assertEquals(expectedValue, actualValue);
    assertEquals(expectedSize, actualSize);

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