package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonInvariantsTest {

  public List<Person> people;

  @BeforeEach
  public void initialization() {
    people = new ArrayList<>();
    people.add(new Person("Jack", 25, "grey"));
    people.add(new Person("Jack", 25, "grey"));
    people.add(new Person("Jack", 25, "grey"));
  }

  @Test
  public void hashCodeOfSameObjectsShouldBeTheSame() {
    assertEquals(people.get(0).hashCode(), people.get(1).hashCode());
  }

  @Test
  public void ifEqualsReturnsTrueHashcodeShouldBeTheSame() {
    assertTrue(people.get(0).equals(people.get(1)));
    assertTrue(people.get(0).hashCode() == people.get(1).hashCode());
  }

  @Test
  public void reflexiveEqualsTest() {
    assertTrue(people.get(0).equals(people.get(1)));
  }

  @Test
  public void symmetricEqualsTest() {
    assertTrue(people.get(0).equals(people.get(1)));
    assertTrue(people.get(1).equals(people.get(0)));
  }

  @Test
  public void transitiveEqualsTest() {
    assertTrue(people.get(0).equals(people.get(2)));
    assertTrue(people.get(1).equals(people.get(2)));
    assertTrue(people.get(0).equals(people.get(2)));
  }

  @Test
  public void consistentEqualsTest() {
    assertTrue(people.get(0).equals(people.get(1)));
    assertTrue(people.get(0).equals(people.get(1)));
    assertTrue(people.get(0).equals(people.get(1)));
  }

  @Test
  public void nullEqualsTest() {
    assertFalse(people.get(0).equals(null));
  }
}