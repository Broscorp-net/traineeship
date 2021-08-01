package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EqualsHashcodeTest {

  private List<EqualsHashcode> list;

  @BeforeEach
  void setup() {
    list = new ArrayList<>();
    EqualsHashcode element1 = new EqualsHashcode("Foo", 5);
    EqualsHashcode element2 = new EqualsHashcode("Foo", 5);
    EqualsHashcode element3 = new EqualsHashcode("Foo", 5);
    list.add(element1);
    list.add(element2);
    list.add(element3);
    for (int i = 1; i < 100; i++) {
      list.add(new EqualsHashcode("Buzz", i));
    }
  }

  /**
   * Hashcode invariants tests.
   */

  @Test
  void testMultipleCallsShouldReturnSameResult() {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      set.add(list.get(0).hashCode());
    }
    assertEquals(1, set.size());
  }

  @Test
  void testIfTwoObjectsAreEqualTheyMustProduceSameHashCode() {
    EqualsHashcode element1 = new EqualsHashcode("Foo", 5);
    EqualsHashcode element2 = new EqualsHashcode("Foo", 5);
    assertEquals(element1, element2);
    assertEquals(element1.hashCode(), element2.hashCode());
  }

  @Test
  void testIfTwoObjectsAreUnequalTheyCanProduceSameHashCode() {
    EqualsHashcode equalsHashcode1 = new EqualsHashcode("Buzz", 5);
    EqualsHashcode equalsHashcode2 = new EqualsHashcode("Foo", 5);
    assertNotEquals(equalsHashcode1, equalsHashcode2);
    assertEquals(equalsHashcode1.hashCode(), equalsHashcode2.hashCode());
  }

  /**
   * Equals invariants tests.
   */

  @Test
  void testEqualsIsReflexive() {
    for (int i = 0; i < 100; i++) {
      assertEquals(list.get(i), list.get(i));
    }
  }

  @Test
  void testEqualsIsSymmetric() {
    EqualsHashcode element1 = new EqualsHashcode("Foo", 5);
    EqualsHashcode element2 = new EqualsHashcode("Foo", 5);
    boolean compare = element1.equals(element2);
    boolean compareVisaVersa = element2.equals(element1);
    boolean isSymmetric = compare == compareVisaVersa;
    assertTrue(isSymmetric);
  }

  @Test
  void testEqualsIsTransitive() {
    EqualsHashcode item1 = new EqualsHashcode("Foo", 5);
    EqualsHashcode item2 = new EqualsHashcode("Foo", 5);
    EqualsHashcode item3 = new EqualsHashcode("Foo", 5);
    boolean compareFirsAndSecond = item1.equals(item2);
    boolean compareSecondAndThird = item2.equals(item3);
    boolean compareFirstToThird = item3.equals(item1);
    boolean isTransitive = false;
    if (compareFirsAndSecond && compareSecondAndThird && compareFirstToThird) {
      isTransitive = true;
    }
    assertTrue(isTransitive);
  }

  @Test
  void testEqualsIsConsistent() {
    EqualsHashcode item1 = new EqualsHashcode("Foo", 5);
    EqualsHashcode item2 = new EqualsHashcode("Foo", 5);
    for (int i = 0; i < 100; i++) {
      assertEquals(item1, item2);
    }
  }

  @Test
  void testEqualsReturnsFalseWhenNonNullObjectsIsComparedWithNull() {
    EqualsHashcode obj = new EqualsHashcode("Foo", 5);
    assertNotEquals(obj, null);
  }

  /**
   * The test searches for the objects with same hash codes, prints them to console and verifies
   * objects inequality and that hash codes are the same.
   */

  @Test
  void findObjectsWithEqualHashCodes() {
    Map<Integer, Set<EqualsHashcode>> map = findUnequalObjectsWithSameHashCode(list);
    printObjectsWithSameHashCode(map);
    for (Map.Entry<Integer, Set<EqualsHashcode>> item : map.entrySet()) {
      checkObjectsAreUnequalButHaveTheSameHashcode(item.getValue());
    }
  }

  private void checkObjectsAreUnequalButHaveTheSameHashcode(Set<EqualsHashcode> value) {
    List<EqualsHashcode> filtered = new ArrayList<>(value);
    for (int i = 0; i < filtered.size() - 1; i++) {
      boolean isSameHashCode = filtered.get(i).hashCode() == filtered.get(i + 1).hashCode();
      boolean isEqual = filtered.get(i).equals(filtered.get(i + 1));
      assertTrue(isSameHashCode);
      assertFalse(isEqual);
    }
  }

  private void printObjectsWithSameHashCode(Map<Integer, Set<EqualsHashcode>> map) {
    for (Map.Entry<Integer, Set<EqualsHashcode>> item : map.entrySet()) {
      Set itemsWithSameHashCode = item.getValue();
      System.out.println("Objects:"
          + "\n"
          + itemsWithSameHashCode.toString()
          + "\n" + "are not equal but have same hashcode"
          + "\n");
    }
  }

  private Map<Integer, Set<EqualsHashcode>> findUnequalObjectsWithSameHashCode(
      List<EqualsHashcode> list) {
    Map<Integer, Set<EqualsHashcode>> map = new HashMap();
    for (int i = 0; i < list.size(); i++) {
      Set<EqualsHashcode> set = new HashSet<>();
      EqualsHashcode object = list.get(i);
      int hash = object.hashCode();
      if (map.containsKey(hash)) {
        map.get(hash).add(object);
      } else {
        set.add(object);
        map.put(hash, set);
      }
    }
    return map;
  }
}


