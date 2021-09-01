package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCoolListTest {

  private MyCoolList myEmptyCoolList;
  private MyCoolList myFiveElementsList;

  @BeforeEach
  void setUp() {
    myEmptyCoolList = new MyCoolList();
    myFiveElementsList = new MyCoolList(5);
    myFiveElementsList.add(0);
    myFiveElementsList.add(1);
    myFiveElementsList.add(2);
    myFiveElementsList.add(3);
    myFiveElementsList.add(4);
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
  void shouldCreateListWithDoubleMemberType() {
    myEmptyCoolList.add(15.262626);
    assertEquals(Double.class, myEmptyCoolList.get(0).getClass());
  }

  @Test
  void shouldCreateListWithIntegerMemberType() {
    myEmptyCoolList.add(5);
    assertEquals(Integer.class, myEmptyCoolList.get(0).getClass());
  }

  @Test
  void shouldCreateListWithTargetInitCapacity() {
    int targetCapacity = 92;
    myEmptyCoolList = new MyCoolList(targetCapacity);
    assertEquals(targetCapacity, myEmptyCoolList.capacity());
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
    myFiveElementsList.add(6);
    assertEquals(6, myFiveElementsList.size());
    assertEquals(7, myFiveElementsList.capacity());
  }

  @Test
  void getShouldThrowIndexOutOfBoundsExceptionWhenIndexLessThanZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.get(-7);
    });
    assertEquals("Index -7 is out of Bounds", exception.getMessage());
  }


  @Test
  void getShouldThrowIndexOutOfBoundsExceptionWhenIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.get(20);
    });
    assertEquals("Index 20 is out of Bounds", exception.getMessage());
  }

  @Test
  void getShouldReturnElementAtIndex() {
    assertEquals(1, myFiveElementsList.get(1));
  }

  @Test
  void removeShouldThrowIndexOutOfBoundsExceptionWhenIndexLessThanZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.remove(-5);
    });
    assertEquals("Index -5 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeShouldThrowIndexOutOfBoundsExceptionWhenIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.remove(105);
    });
    assertEquals("Index 105 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeShouldRemoveElementAtIndexAndDecreaseSizeByOne() {
    int size = myFiveElementsList.size();
    myFiveElementsList.remove(2);
    assertNotEquals(2, myFiveElementsList.get(2));
    assertEquals(size - 1, myFiveElementsList.size());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenStartIndexBlowZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.removeRange(-6, 8);
    });
    assertEquals("Index -6 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenStartIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.removeRange(15, 8);
    });
    assertEquals("Index 15 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenEndIndexExceedsCapacity() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.removeRange(2, 8);
    });
    assertEquals("Index 8 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldThrowIndexOutOfBoundsExceptionWhenEndIndexBelowZero() {
    Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
      myFiveElementsList.removeRange(2, -9);
    });
    assertEquals("Index -9 is out of Bounds", exception.getMessage());
  }

  @Test
  void removeRangeShouldRemoveRange() {
    myFiveElementsList.removeRange(1, 3);
    assertEquals(2, myFiveElementsList.size());
  }

  @Test
  void mapShouldThrowMapIntegerToDouble() {
    MyCoolList<Integer> intList = new MyCoolList<>();
    intList.add(15);
    MyCoolList<Double> list = intList.map(e -> 15 * 3.14);
    assertEquals(Double.class, list.get(0).getClass());
  }
}
