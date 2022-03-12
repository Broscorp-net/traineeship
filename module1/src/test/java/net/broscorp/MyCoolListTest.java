package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  @Test
  public void overflowTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 100; i++) {
      name.add(i);
    }
    //Checking if list elements have the right values
    assertEquals(name.get(5), 5);
    assertEquals(name.get(50), 50);
    //This test would fail if resizeList() isn't working properly
    assertEquals(name.size(), 100);
  }

  @Test
  public void mapTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
    }

    //This block would add the value to itself
    //If array[1] contains 1
    //Then after map() it would contain 2
    name = name.map((Integer x) -> x + x);
    assertEquals(2, name.get(1));

    //By repeating the procedure, we see that the results are consistent
    name = name.map((Integer x) -> x + x);
    assertEquals(4, name.get(1));
  }

  @Test
  public void addTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
      assertEquals(name.get(i), i);
    }
  }

  @Test
  public void getTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
      assertEquals(name.get(i), i);
    }
    assertThrows(IndexOutOfBoundsException.class, () -> name.get(11));
  }

  @Test
  public void removeTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
    }
    //Checking the arraylist rearrangement
    name.remove(5);
    assertEquals(6, name.get(5));
    //Checking if removed last element is set to null
    name.remove(8);
    assertEquals(null, name.get(8));
  }

  @Test
  public void copyTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
    }
    MyCoolList<Integer> anothername = name.copyList();
    //Checking if the list is copied correctly
    assertEquals(5, anothername.get(5));
  }

  @Test
  public void setTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
    }
    //Setting the element to 999 and checking if it works
    name.set(999, 5);
    assertEquals(999, name.get(5));
  }

  @Test
  public void sizeTest() {
    MyCoolList<Integer> name = new MyCoolList();
    for (int i = 0; i < 10; i++) {
      name.add(i);
    }
    assertEquals(10, name.size());
  }
}
