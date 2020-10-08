package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class EqualsHashCodeTest {

  @Test
  void testEquals() {
    EqualsHashCode var1 = new EqualsHashCode("a", "a", "a");
    EqualsHashCode var2 = new EqualsHashCode("a", "a", "a");


    EqualsHashCode var3 = new EqualsHashCode("b", "b", "b");
    EqualsHashCode var4 = new EqualsHashCode("c", "c", "c");

    assertTrue(var1.equals(var2));
    assertTrue(var2.equals(var1));
    assertFalse(var3.equals(var4));
    assertFalse(var4.equals(var3));
    assertFalse(var4.equals(null));
  }

  @Test
  void testHashCode() {
    EqualsHashCode var1 = new EqualsHashCode("a", "a", "a");
    EqualsHashCode var2 = new EqualsHashCode("a", "a", "a");

    EqualsHashCode var3 = new EqualsHashCode("b", "b", "b");
    EqualsHashCode var4 = new EqualsHashCode("c1", "c1", "c1");

    assertTrue(var1.hashCode() == var2.hashCode());
    assertFalse(var3.hashCode() == var4.hashCode());
  }

  @Test
  void findSameHashCodeByFor() {
    List<EqualsHashCode> list = new ArrayList<>();

    for (int i = 0; i <= 10; i++) {
      list.add(new EqualsHashCode("a" + i, "b" + i, "c" + i));
    }

    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size() - 1; j++) {
        if (list.get(i).hashCode() == list.get(j).hashCode() && !list.get(i).equals(list.get(j))) {
          System.out.println(
                 "Вот объект " + list.get(i).toString() + ", вот объект " + list.get(j).toString()
                 + ", они разные, но их хеш сопадает");
          assertEquals(list.get(i).hashCode(), list.get(j).hashCode());
          assertNotEquals(list.get(i), list.get(j));

        }
        break;
      }

    }
  }
}