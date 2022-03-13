package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  private static final Integer NUM_1 = 5;
  private static final Integer NUM_2 = 10;
  private static final Integer NUM_3 = 100;
  private static final Integer NUM_4 = 50;

  private MyCoolList<Integer> intList;

  @BeforeEach
  void setUp() {
    intList = new MyCoolList<>();
  }

  @Test
  void addTest() {
    assertEquals(0, intList.size());

    intList.add(NUM_1);
    assertEquals(1,intList.size());
  }

  @Test
  void addTwoObjectsTest() {
    assertEquals(0, intList.size());

    intList.add(NUM_1);
    assertEquals(1,intList.size());

    intList.add(NUM_2);
    assertEquals(2,intList.size());
  }

  @Test
  void getOneObjectTest() {
    intList.add(NUM_1);

    assertEquals(NUM_1, intList.get(0));
  }

  @Test
  void getTwoObjectsTest() {
    intList.add(NUM_1);

    assertEquals(NUM_1, intList.get(0));

    intList.add(NUM_2);

    assertEquals(NUM_2, intList.get(1));
  }

  @Test
  void removeByIndexTest() {
    intList.add(NUM_1);
    intList.add(NUM_2);
    intList.add(NUM_3);
    intList.add(NUM_4);

    assertEquals(NUM_3, intList.get(2));

    intList.remove(2);

    assertEquals(NUM_4, intList.get(2));
  }

  @Test
  void removeNonExistElementTest() {
    intList.add(NUM_1);
    intList.add(NUM_2);

    Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> intList.remove(5));
    assertEquals(exception.getMessage(), "Index 5 out of bounds for length 2");
  }

  @Test
  void getIfIndexBigTest() {
    intList.add(NUM_1);
    intList.add(NUM_2);
    intList.add(NUM_3);
    intList.add(NUM_4);

    Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> intList.get(10));
    assertEquals(exception.getMessage(), "Index 10 out of bounds for length 4");
  }

  @Test
  void getIfIndexLessThanZeroTest() {
    intList.add(NUM_1);
    intList.add(NUM_2);

    Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> intList.get(-4));
    assertEquals(exception.getMessage(), "Index -4 out of bounds for length 2");
  }

  @Test
  void addNullTest() {
    intList.add(null);

    assertEquals(1, intList.size());
  }

  @Test
  void getNullElementTest() {
    intList.add(null);

    assertNull(intList.get(0));
  }

  @Test
  void getSizeTest() {
    assertEquals(0, intList.size());

    intList.add(NUM_2);
    intList.add(NUM_3);
    intList.add(NUM_4);

    assertEquals(4, intList.size());
  }

  @Test
  void functionTest() {
    MyCoolList<Integer> myCoolList;
    intList.add(NUM_2);
    intList.add(NUM_3);
    intList.add(NUM_4);

    myCoolList = intList.map(e -> e * 2);

    System.out.println(myCoolList.size());

//    assertEquals(20, myCoolList.get(0));
//    assertEquals(200, myCoolList.get(1));
//    assertEquals(100, myCoolList.get(2));
  }
}
