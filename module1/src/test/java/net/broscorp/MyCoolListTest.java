package net.broscorp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  private static MyCoolList<Integer> name = new MyCoolList();

  /**
   * Initilizing MyCoolList.
   */
  @BeforeAll
  public static void initialize() {
    for (int i = 0; i < 10; i++) {
      name.add(i);
    }
  }

  @Test
  public void overflowTest() {
    MyCoolList<Integer> overflowed = new MyCoolList();
    for (int i = 0; i < 100; i++) {
      overflowed.add(i);
    }
    //Checking if list elements have the right values
    assertEquals(overflowed.get(5), 5);
    assertEquals(overflowed.get(50), 50);
    //This test would fail if resizeList() isn't working properly
    assertEquals(overflowed.size(), 100);
  }

  @Test
  public void mapTest() {
    //This block would add the value to itself
    //If array[1] contains 1
    //Then after map() it would contain 2
    name = name.map((Integer x) -> x + x);
    assertEquals(2, name.get(1));

    //By repeating the procedure, we see that the results are consistent
    name = name.map((Integer x) -> x + x);
    assertEquals(4, name.get(1));

    //Map to Double test
    //First list
    MyCoolList<Integer> list = new MyCoolList<>();
    list.add(3);
    //Double list
    MyCoolList<Double> newlist;
    newlist = list.map((Integer e) -> Double.valueOf(e));
    assertEquals(3.0, newlist.get(0));
    assertTrue(newlist.get(0) instanceof Double);
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
    assertEquals(9, name.get(9));
    assertThrows(IndexOutOfBoundsException.class, () -> name.get(11));
  }

  @Test
  public void removeTest() {
    //Current list: 4 8 12 16 20 24 28 ... (due to mapTest)
    //Checking the arraylist rearrangement
    name.remove(5);
    assertEquals(24, name.get(5));
    //Checking if removed last element is set to null
    name.remove(8);
    assertNull(name.get(8));
  }

  @Test
  public void copyTest() {
    MyCoolList<Integer> anothername = name.copyList();
    //Checking if the list is copied correctly
    assertEquals(5, anothername.get(5));
  }

  @Test
  public void sizeTest() {
    assertEquals(10, name.size());
  }
}
