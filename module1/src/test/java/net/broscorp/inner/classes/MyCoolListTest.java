package net.broscorp.inner.classes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList myEmptyCoolList;
  private MyCoolList myFiveElementslList;
  private MyCoolList<Integer> myParametrizedCoolList;
  private Iterator iterator;

  @BeforeEach
  void setUp() {
    myEmptyCoolList = new MyCoolList();
    myFiveElementslList = new MyCoolList(5);
    myFiveElementslList.add(0);
    myFiveElementslList.add(1);
    myFiveElementslList.add(2);
    myFiveElementslList.add(3);
    myFiveElementslList.add(4);
    myParametrizedCoolList = new MyCoolList();
    myParametrizedCoolList.add(0);
    myParametrizedCoolList.add(1);
    myParametrizedCoolList.add(2);
    myParametrizedCoolList.add(3);
    myParametrizedCoolList.add(4);
  }

  @Test
  void shouldCreateListWithCapacityOfTen() {
    assertEquals(10, myEmptyCoolList.capacity());
    assertEquals(0, myEmptyCoolList.size());
  }

  @Test
  void shouldThrowIllegalArgumentExceptionWhenCreatingListWithWrongParameters() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      myEmptyCoolList = new MyCoolList(-1);
    });
    assertEquals("Capacity can't be negative", exception.getMessage());
  }

  @Test
  void shouldCreateListWithStringMemberType() {
    myEmptyCoolList.add("String type added succesfully");
    assertEquals(String.class, myEmptyCoolList.get(0).getClass());
  }

  @Test
  void shouldCreateListWithDoubleMemberType() {
    myEmptyCoolList.add(15.262626);
    assertEquals(Double.class, myEmptyCoolList.get(0).getClass());
  }

  @Test
  void shouldCreateListWithObjectMemberType() {
    myEmptyCoolList.add(new Object());
    assertEquals(Object.class, myEmptyCoolList.get(0).getClass());
  }

  @Test
  void shouldCreateListWithTargetInitCapacity() {
    int targetCapacity = 92;
    myEmptyCoolList = new MyCoolList(targetCapacity);
    assertEquals(targetCapacity, myEmptyCoolList.capacity());
  }

  @Test
  void shouldReturnDefaultSizeOfTen() {
    assertEquals(10, myEmptyCoolList.capacity());
  }

  @Test
  void shouldAddElementToEmptyListAtZeroIndex() {
    myEmptyCoolList.add(1);
    assertEquals(1, myEmptyCoolList.size());
  }

  @Test
  void shouldInsertElementWithoutSizeExtensionWhenCreatingDefCapList() {
    myEmptyCoolList.add(1);
    myEmptyCoolList.add(2);
    myEmptyCoolList.add(3);
    assertEquals(3, myEmptyCoolList.size());
    assertEquals(10, myEmptyCoolList.capacity());
  }

  @Test
  void shouldInsertElementWithoutSizeExtensionWhenParametrizingCapacity() {
    MyCoolList myCoolList = new MyCoolList(15);
    myCoolList.add(1);
    myCoolList.add(2);
    myCoolList.add(3);
    assertEquals(3, myCoolList.size());
    assertEquals(15, myCoolList.capacity());
  }

  @Test
  void listShouldExtendAndAddElementWhenAddedElementIsOutOfBounds() {
    myFiveElementslList.add(6);
    assertEquals(6, myFiveElementslList.size());
    assertEquals(7, myFiveElementslList.capacity());
  }

  @Test
  void getShouldThrowIndexOutOfBoundsExceptionWhenIndexLessThanZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.get(-7);
    });
    assertEquals("Index -7 is out of Bounds", exception.getMessage());
  }


  @Test
  void getShouldThrowIndexOutOfBoundsExceptionWhenIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.get(20);
    });
    assertEquals("Index 20 is out of Bounds", exception.getMessage());
  }

  @Test
  void getShouldReturnElementAtIndex() {
    assertEquals(1, myFiveElementslList.get(1));
  }

  @Test
  void removeShouldThrowIndexOutOfBoundsExceptionWhenIndexLessThanZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.removeByIndex(-5);
    });
    assertEquals("Index -5 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeShouldThrowIndexOutOfBoundsExceptionWhenIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.removeByIndex(105);
    });
    assertEquals("Index 105 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeShouldRemoveElementAtIndexAndDecreaseSizeByOne() {
    int size = myFiveElementslList.size();
    myFiveElementslList.removeByIndex(2);
    assertNotEquals(2, myFiveElementslList.get(2));
    assertEquals(size - 1, myFiveElementslList.size());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenStartIndexBlowZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.removeRange(-6, 8);
    });
    assertEquals("Index -6 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenStartIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.removeRange(15, 8);
    });
    assertEquals("Index 15 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenEndIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.removeRange(2, 8);
    });
    assertEquals("Index 8 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenEndIndexBelowZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementslList.removeRange(2, -9);
    });
    assertEquals("Index -9 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldRemoveRange() {
    myFiveElementslList.removeRange(1, 3);
    assertEquals(2, myFiveElementslList.size());
  }

  @Test
  void mapShouldThrowNullPointer() {
    MyCoolList<Integer> listOfIntegers = new MyCoolList();
    Throwable exception = assertThrows(NullPointerException.class, () -> {
      listOfIntegers.map(String::valueOf);
    });
    assertEquals("Operation on empty or null element", exception.getMessage());
  }

  @Test
  void mapShouldThrowMapIntegerToString() {
    MyCoolList<String> list = myFiveElementslList.map(String::valueOf);
    assertEquals(String.class, list.get(0).getClass());
  }

  @Test
  void mapShouldThrowMapIntegerToDouble() {
    MyCoolList<Integer> intList = new MyCoolList<>();
    intList.add(15);
    MyCoolList<Double> list = intList.map(e -> 15 * 3.14);
    assertEquals(Double.class, list.get(0).getClass());
  }

  @Test
  void containsShouldThrowNullPinterException() {
    Throwable exception = assertThrows(NullPointerException.class, () -> {
      myEmptyCoolList.contains(null);
    });
    assertEquals("Can't process nullable elements", exception.getMessage());
  }

  @Test
  void containsShouldReturnFalse() {
    assertFalse(myParametrizedCoolList.contains(56));
  }

  @Test
  void containsShouldReturnTrue() {
    assertTrue(myParametrizedCoolList.contains(1));
  }

  @Test
  void removeByValueShouldRemoveItem() {
    myParametrizedCoolList.removeByValue(1);
    assertFalse(myParametrizedCoolList.contains(1));
  }

  @Test
  void removeByValueShouldThrowIllegalArgumentException() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      myParametrizedCoolList.removeByValue(20);
    });
    assertEquals("The list doesn't contain value 20", exception.getMessage());
  }

  /**
   * Iterator implementation tests.
   */

  @Test
  void forEachIteratorShouldBeAvailable() {
    List<Integer> list = new ArrayList();
    MyCoolList<Integer> newList = new MyCoolList<>();
    newList.add(1);
    newList.add(2);
    newList.add(3);
    for (Integer i : newList) {
      list.add(i);
    }
    assertEquals(list.size(), newList.size());
    //check if elements are equal
    for (int i = 0; i < newList.size(); i++) {
      assertEquals(list.get(i), newList.get(i));
    }
  }

  @Test
  void hasNextShouldReturnTrue() {
    iterator = myFiveElementslList.iterator();
    assertTrue(iterator.hasNext());
  }

  @Test
  void hasNextShouldReturnFalse() {
    iterator = myEmptyCoolList.iterator();
    assertFalse(iterator.hasNext());
  }

  @Test
  void nextShouldReturnZeroElement() {
    iterator = myParametrizedCoolList.iterator();
    MyCoolList<Integer> myCoolList = new MyCoolList<>();
    while (iterator.hasNext()) {
      Integer i = (Integer) iterator.next();
      myCoolList.add(i);
    }
    assertEquals(myCoolList.get(0), myParametrizedCoolList.get(0));
  }


  @Test
  void removeShouldRemoveElementByIndex() {
    iterator = myParametrizedCoolList.iterator();
    while (iterator.hasNext()) {
      Integer i = (Integer) iterator.next();
      if (i.equals(1)) {
        iterator.remove();
      }
    }
    assertEquals(4, myParametrizedCoolList.size());
    assertFalse(myParametrizedCoolList.contains(1));
  }
}