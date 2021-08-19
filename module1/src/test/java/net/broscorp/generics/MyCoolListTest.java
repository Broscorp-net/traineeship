package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  @Test
  public void shouldReturnSizeOfList() {
    //given
    MyCoolList<Double> coolList = new MyCoolList<>();
    //when
    int size = coolList.size();
    //then
    assertEquals(0, size);
  }

  @Test
  public void shouldAddItemToList() {
    //given
    MyCoolList<Double> coolList = new MyCoolList<>();
    int listSize = coolList.size();
    //when
    coolList.add(15.0);
    //then
    assertEquals(listSize + 1, coolList.size());
  }

  @Test
  public void shouldAddItemAndExpandList() {
    //given
    MyCoolList<Integer> coolList = new MyCoolList<>();
    for (int i = 0; i < 10; i++) {
      coolList.add(i);
    }
    int beforeListSize = coolList.size();
    //when
    coolList.add(150);
    int afterListSize = coolList.size();
    //then
    assertEquals(beforeListSize + 1, afterListSize);
  }

  @Test
  public void shouldGetItemByIndex() {
    //given
    MyCoolList<Integer> coolList = new MyCoolList<>();
    Integer expectedItem = 111;
    coolList.add(expectedItem);
    //when
    Integer actualItem = coolList.get(0);
    //then
    assertEquals(expectedItem, actualItem);
  }

  @Test
  public void shouldRemoveFistItemByIndex() {
    //given
    MyCoolList<Integer> coolList = new MyCoolList<>();
    Integer expectedItem = 111;
    coolList.add(expectedItem);
    int size = coolList.size();
    //when
    Integer actualItem = coolList.remove(0);
    //then
    assertEquals(size - 1, coolList.size());
    assertEquals(expectedItem, actualItem);
  }

  @Test
  public void shouldRemoveMiddleItemByIndex() {
    //given
    MyCoolList<Integer> coolList = new MyCoolList<>();
    coolList.add(0);
    coolList.add(1);
    coolList.add(2);
    int size = coolList.size();
    //when
    Integer actualItem = coolList.remove(1);
    //then
    assertEquals(size - 1, coolList.size());
    assertEquals(1, actualItem);
  }

  @Test
  public void shouldRemoveLastItemByIndex() {
    //given
    MyCoolList<Integer> coolList = new MyCoolList<>();
    coolList.add(0);
    coolList.add(1);
    coolList.add(2);
    int size = coolList.size();
    //when
    Integer actualItem = coolList.remove(size - 1);
    //then
    assertEquals(size - 1, coolList.size());
    assertEquals(2, actualItem);
  }

  @Test
  public void shouldMapIntegersToDouble() {
    //given
    MyCoolList<Integer> coolList = new MyCoolList<>();
    coolList.add(2);
    coolList.add(3);
    //when
    MyCoolList<Double> doubleMyCoolList = coolList.map(t -> t + 0.1);
    //then
    assertTrue(doubleMyCoolList.size() > 0);
    assertEquals(Double.class, doubleMyCoolList.get(0).getClass());
    assertEquals(Double.valueOf(2.1), doubleMyCoolList.get(0));
  }

  @Test
  public void shouldMapDoubleToShort() {
    //given
    MyCoolList<Double> coolList = new MyCoolList<>();
    coolList.add(2.0);
    coolList.add(3.14);
    //when
    MyCoolList<Short> shortMyCoolList = coolList.map(Double::shortValue);
    //then
    assertTrue(shortMyCoolList.size() > 0);
    assertEquals(Short.class, shortMyCoolList.get(0).getClass());
    assertEquals(Short.valueOf("3"), shortMyCoolList.get(1));
  }

}
