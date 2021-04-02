package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MyCoolCollectionTest {

  private MyCoolCollection<Integer> myCoolCollection;

  @BeforeEach
  void setUp() {
    myCoolCollection = new MyCoolCollection<>();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  @DisplayName("Should add object to collection")
  void shouldAddObjectToCollection() {
    int expectedSize = 0;
    int actualSize = 0;

    assertEquals(expectedSize, actualSize);

    myCoolCollection.add(1);
    myCoolCollection.add(new Integer(5));
    myCoolCollection.add(10);
    myCoolCollection.add(7);

    expectedSize = 4;
    actualSize = myCoolCollection.size();

    assertEquals(expectedSize, actualSize);

  }

  @Test
  @DisplayName("Should return object from collection")
  void shouldGetObjectFromCollection() {
    final int expectedValue1 = 5;
    final int expectedValue2 = 7;

    myCoolCollection.add(1);
    myCoolCollection.add(5);
    myCoolCollection.add(10);
    myCoolCollection.add(7);

    int actualValue1 = myCoolCollection.get(1);
    int actualValue2 = myCoolCollection.get(3);

    assertEquals(expectedValue1, actualValue1);
    assertEquals(expectedValue2, actualValue2);

  }

  @Test
  @DisplayName("Should throw IndexOutOfBoundsException in get")
  void shouldThrowIndexOutOfBoundsExceptionInGet() {

    myCoolCollection.add(1);
    myCoolCollection.add(5);
    myCoolCollection.add(10);
    myCoolCollection.add(7);

    assertThrows(IndexOutOfBoundsException.class, () -> myCoolCollection.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> myCoolCollection.get(4));

  }

  @Test
  @DisplayName("Should remove object from collection")
  void shouldRemoveObjectFromCollection() {

    myCoolCollection.add(1);
    myCoolCollection.add(5);
    myCoolCollection.add(10);
    myCoolCollection.add(7);

    int expectedSize = 4;
    final int expectedItem = 10;

    int actualSize = myCoolCollection.size();

    assertEquals(expectedSize, actualSize);

    expectedSize = 3;

    int actualItem = myCoolCollection.remove(2);

    actualSize = myCoolCollection.size();

    assertEquals(expectedItem, actualItem);
    assertEquals(expectedSize, actualSize);

  }

  @Test
  @DisplayName("Should throw IndexOutOfBoundsException in remove")
  void shouldThrowIndexOutOfBoundsExceptionInRemove() {

    myCoolCollection.add(1);
    myCoolCollection.add(5);
    myCoolCollection.add(10);
    myCoolCollection.add(7);

    assertThrows(IndexOutOfBoundsException.class, () -> myCoolCollection.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> myCoolCollection.get(4));

  }

  @Test
  @DisplayName("Should map base collection")
  void shouldMapCollection() {

    myCoolCollection.add(1);
    myCoolCollection.add(5);
    myCoolCollection.add(10);
    myCoolCollection.add(7);

    final int expectedSize = 4;
    int expectedItem = 10;

    int actualSize = myCoolCollection.size();
    int actualItem = myCoolCollection.get(2);

    assertEquals(expectedSize, actualSize);
    assertEquals(expectedItem, actualItem);

    expectedItem = 100;

    myCoolCollection.map((x) -> x * 10);

    actualSize = myCoolCollection.size();
    actualItem = myCoolCollection.get(2);

    assertEquals(expectedSize, actualSize);
    assertEquals(expectedItem, actualItem);

  }

  @Test
  @DisplayName("Should return the number objects in collection")
  void shouldReturnSizeCollection() {

    int expectedSize = 0;
    int actualSize = myCoolCollection.size();

    assertEquals(expectedSize, actualSize);

    myCoolCollection.add(10);
    myCoolCollection.add(5);
    myCoolCollection.add(10);

    expectedSize = 3;
    actualSize = myCoolCollection.size();

    assertEquals(expectedSize, actualSize);

    myCoolCollection.add(210);
    myCoolCollection.add(17);

    expectedSize = 5;
    actualSize = myCoolCollection.size();

    assertEquals(expectedSize, actualSize);

    myCoolCollection.remove(1);

    expectedSize = 4;
    actualSize = myCoolCollection.size();

    assertEquals(expectedSize, actualSize);

  }
}