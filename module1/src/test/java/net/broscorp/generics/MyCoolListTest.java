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
    int expectedInteger = 3;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(8);

    int actualInteger = myCoolListInteger.size();

    assertEquals(expectedInteger, actualInteger);

    MyCoolList<Float> myCoolListFloat = new MyCoolList<>();
    int expectedFloat = 3;

    myCoolListFloat.add(5.7F);
    myCoolListFloat.add(new Float(10.9F));
    myCoolListFloat.add(8F);

    int actualFloat = myCoolListFloat.size();

    assertEquals(expectedFloat, actualFloat);

  }

  @Test
  @DisplayName("Should get element from list")
  void shouldGetElementFromList() {
    int expected = 7;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    int actual = myCoolListInteger.get(3);

    assertEquals(expected, actual);

  }

  @Test
  @DisplayName("Should remove element from list")
  void shouldRemoveElementFromList() {
    int expectedElement = 7;
    int expectedSize = 3;

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    int actualElement = myCoolListInteger.remove(3);
    int actualSize = myCoolListInteger.size();

    assertEquals(expectedElement, actualElement);
    assertEquals(expectedSize, actualSize);

  }

  @Test
  @DisplayName("Should get list elements from list")
  void map() {
  }

  @Test
  @DisplayName("Should return the number elements in the list")
  void shouldReturnSizeList() {
    int expectedZeroSize = 0;
    int expectedAddSize = 4;
    int expectedRemoveSize = 3;

    int actualZeroSize = myCoolListInteger.size();
    assertEquals(expectedZeroSize, actualZeroSize);

    myCoolListInteger.add(5);
    myCoolListInteger.add(new Integer(10));
    myCoolListInteger.add(3);
    myCoolListInteger.add(Integer.valueOf(7));

    int actualAddSize = myCoolListInteger.size();
    assertEquals(expectedAddSize, actualAddSize);

    myCoolListInteger.remove(3);
    int actualRemoveSize = myCoolListInteger.size();
    assertEquals(expectedRemoveSize, actualRemoveSize);

  }
}