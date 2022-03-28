package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class HumanTest {
  private static List<Human> humans = new ArrayList<>();

  @BeforeAll
  public static void config() {
    humans.add(new Human("Dan", "Yan", 22));
    humans.add(new Human("Dan", "Yan", 22));
    humans.add(new Human("Sam", "San", 42));
    humans.add(new Human("Sam", "San", 42));
    humans.add(new Human("Ban", "Grer", 32));
  }

  @Test
  public void checkEqualsForTwoObjects() {
    assertTrue(humans.get(0).equals(humans.get(1)));
  }

  @Test
  public void checkHashOneObject() {
    assertEquals(humans.get(0).hashCode(), humans.get(0).hashCode());
  }

  @Test
  public void checkEqualsObjectsAndSameHash() {
    assertTrue(humans.get(0).equals(humans.get(1)));
    assertEquals(humans.get(0).hashCode(), humans.get(1).hashCode());
  }

  @Test
  public void checkEqualsNull() {
    assertFalse(humans.get(0).equals(null));
  }

  @Test
  public void checkNotEqualObjectsWithSameHashcode() {
    for (int i = 0; i < humans.size(); i++) {
      for (int j = i; j < humans.size(); j++) {
        if (!humans.get(i).equals(humans.get(j))) {
          if (humans.get(i).hashCode() == humans.get(j).hashCode()) {
            System.out.println("Objects " + humans.get(i) + " and " + humans.get(j)
                    + " not equals but have same hashcode");
            assertFalse(humans.get(i).equals(humans.get(j)));
            assertTrue(humans.get(i).hashCode() == humans.get(j).hashCode());
          }
        }
      }
    }
  }
}