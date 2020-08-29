package net.broscorp.inner;

import java.util.Iterator;
import java.util.function.Function;
import net.broscorp.inner.classes.MyIterableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyIterableListTest {

  @Test
  public void testAddLong() {
    MyIterableList<Long> list = new MyIterableList<>();
    list.add(34L);
    list.add(1000L);
    list.add(123L);
    list.add(444000L);

    Assertions.assertEquals(4, list.size());
  }

  @Test
  public void testAddDouble() {
    MyIterableList<Double> list = new MyIterableList<>();
    list.add(34.0);
    list.add(1.656);

    Assertions.assertEquals(2, list.size());
  }

  @Test
  public void testAddMoreElementsThanDefaultCapacity10() {
    MyIterableList<Double> list = new MyIterableList<>();
    list.add(34.0);
    list.add(2.5);
    list.add(1.656);
    list.add(1.0);
    list.add(1446.12);
    list.add(2.5);
    list.add(1.656);
    list.add(1.0);
    list.add(1446.12);
    list.add(2.5);
    list.add(1.656);
    list.add(1.0);
    list.add(1446.12);
    list.add(2.5);
    list.add(1.656);
    list.add(1.0);
    list.add(1446.12);

    Assertions.assertEquals(17, list.size());
  }

  @Test
  public void testGet() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10); // index 2

    Integer result = list.get(2);
    Assertions.assertEquals(10, result);
  }

  @Test
  public void testGetThrowsIndexOutOfBoundsException() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10);

    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
  }

  @Test
  public void testRemoveThrowsIndexOutOfBoundsException() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10);

    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
  }

  @Test
  public void testRemove() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10); // index 2

    Integer removedItem = list.remove(2);
    Assertions.assertEquals(10, removedItem);
    Assertions.assertEquals(2, list.size());
  }

  @Test
  public void testRemoveFromTheMiddleOfList() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10);
    list.add(100); // index 3
    list.add(-50);
    list.add(-1000);

    Integer removedItem = list.remove(3);

    Assertions.assertEquals(100, removedItem);
    Assertions.assertEquals(5, list.size());

    Assertions.assertNotNull(list.get(3));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
  }

  @Test
  public void testMap() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10);

    Function<Integer, Integer> function = n -> n * 5;

    MyIterableList<Number> actualResult = list.map(function);

    Assertions.assertEquals(3, actualResult.size());
    Assertions.assertEquals(25, actualResult.get(0));
    Assertions.assertEquals(10, actualResult.get(1));
    Assertions.assertEquals(50, actualResult.get(2));
  }

  @Test
  public void testIteratorHasNextReturnTrue() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10);

    Iterator<Integer> iterator = list.iterator();

    Assertions.assertTrue(iterator.hasNext());
    Assertions.assertTrue(iterator.hasNext());
  }

  @Test
  public void testIteratorHasNextReturnsFalse() {
    MyIterableList<Integer> list = new MyIterableList<>();

    Iterator<Integer> iterator = list.iterator();

    Assertions.assertFalse(iterator.hasNext());
    Assertions.assertFalse(iterator.hasNext());
  }

  @Test
  public void testIteratorNext() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);
    list.add(2);
    list.add(10);

    Iterator<Integer> iterator = list.iterator();

    Assertions.assertEquals(5, iterator.next());
    Assertions.assertEquals(2, iterator.next());
    Assertions.assertEquals(10, iterator.next());
  }

  @Test
  public void testIteratorNextOutOfBounds() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);

    Iterator<Integer> iterator = list.iterator();

    Assertions.assertEquals(5, iterator.next());
    Assertions.assertThrows(IndexOutOfBoundsException.class,
        () -> iterator.next());
  }

  @Test
  public void testIteratorRemoveThrowsUnsupportedOperationException() {
    MyIterableList<Integer> list = new MyIterableList<>();
    list.add(5);

    Iterator<Integer> iterator = list.iterator();

    Assertions.assertThrows(UnsupportedOperationException.class,
        () -> iterator.remove());
  }
}
