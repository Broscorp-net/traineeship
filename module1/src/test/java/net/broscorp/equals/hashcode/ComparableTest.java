package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ComparableTest {

  @Test
  void givenComparableObject_whenCompareWithNull_thenFalseReturned() {
    Comparable comparable = new Comparable();

    assertFalse(comparable.equals(null));
  }

  @Test
  void givenComparableObject_whenCompareWithItself_thenTrueReturned() {
    Comparable comparable = new Comparable("Comparable", 444, false, 'T');

    assertTrue(comparable.equals(comparable));
  }

  /*
   * Transitivity
   *
   * */

  @Test
  void givenThreeEqualObjects_whenCompareAll_thenTrueReturned() {
    Comparable first = new Comparable("Comparable", 404, true, 'q');
    Comparable second = new Comparable("Comparable", 404, true, 'q');
    Comparable third = new Comparable("Comparable", 404, true, 'q');

    assertTrue(first.equals(second));
    assertTrue(second.equals(third));
    assertTrue(first.equals(third));
  }


  /*
   * Symmetry
   *
   * */

  @Test
  void givenTwoEqualObjects_whenReversCompare_thenTrueReturned() {
    Comparable first = new Comparable("Comparable", 4, true, 'r');
    Comparable second = new Comparable("Comparable", 4, true, 'r');

    assertTrue(first.equals(second));
    assertTrue(second.equals(first));
  }

  @Test
  void givenTwoDifferentObjects_whenReversCompare_thenFalseReturned() {
    Comparable first = new Comparable("First", 1, true, 'n');
    Comparable second = new Comparable("Second", 17, false, 'k');

    assertFalse(first.equals(second));
    assertFalse(second.equals(first));
  }

  /*
   * Consistency
   *
   * */
  @Test
  void givenTwoEqualsObject_whenCompareWithDifferentThirdObject_thenFalseReturned() {
    Comparable first = new Comparable("FirstComparable", 11, false, 'k');
    Comparable second = new Comparable("FirstComparable", 11, false, 'k');
    Comparable third = new Comparable("Comparable", 404, true, 'q');

    assertTrue(first.equals(second));
    assertFalse(first.equals(third));

    assertFalse(second.equals(third));
    assertTrue(second.equals(first));

    assertFalse(third.equals(first));
    assertFalse(third.equals(second));
  }

  /*
   * Hashcode should be equal
   * */

  @Test
  void givenObject_whenCompareHashCode_thenTrueReturned() {
    Comparable comparable = new Comparable("Comparable", 444, false, 'T');
    int first = comparable.hashCode();
    int second = comparable.hashCode();

    assertEquals(first, second);
  }

  @Test
  void givenTwoEqualObject_whenCompareHashCode_thenTruReturned() {
    Comparable first = new Comparable("FirstComparable", 11, false, 'k');
    Comparable second = new Comparable("FirstComparable", 11, false, 'k');
    int firstHashcode = first.hashCode();
    int secondHashcode = second.hashCode();

    assertTrue(first.equals(second));
    assertEquals(firstHashcode, secondHashcode);
  }

  @Test
  void givenListObjects_whenCompareDifferentObjectsOfList_thenHashCodesIsEqual() {
    List<Comparable> objects = new ArrayList<>(
        Arrays.asList(new Comparable[]{new Comparable("bar", 14, true, 'a'),
            new Comparable("arb", 14, true, 'a'), new Comparable("some", 14, true, 'a'),
            new Comparable("done", 14, true, 'a')}));

    objects.stream().collect(Collectors.groupingBy(comparable -> comparable.hashCode()))
        .forEach((key, list) -> {
          list.forEach(x -> System.out.println("Вот объект " + x.toString() + ","));
          System.out.println("они разные, но их хеш совпадает");
          list.forEach(x -> {
            assertEquals(list.get(0).hashCode(), x.hashCode());
            assertFalse(list.get(0).equals(list.get(1)));
          });
        });
  }
}