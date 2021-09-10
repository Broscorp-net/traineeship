package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  ArrayList<Person> persons;
  StringBuilder message;
  Person bob;
  Person bob2;
  Person bob3;
  Person alice;
  Person chris;
  Person radim;
  Person daniel;

  @BeforeEach
  void init() {
    bob = new Person("Bob", 23, "12345");
    bob2 = new Person("Bob", 23, "12345");
    bob3 = new Person("Bob", 23, "12345");
    alice = new Person("Alice", 23, "12345");
    chris = new Person("Chris", 29, "12113");
    radim = new Person("Radim", 32, "14113");
    daniel = new Person("Daniel", 31, "13276");
  }

  @Test
  void reflexiveTest() {
    assertEquals(bob, bob);
  }

  @Test
  void symmetricTest() {
    assertTrue(bob.equals(bob2) && bob2.equals(bob));
  }

  @Test
  void transitiveTest() {
    assertTrue(bob.equals(bob2) && bob2.equals(bob3)
        && bob.equals(bob3));
  }

  @Test
  void consistentTest() {
    assertTrue(bob.equals(bob2) && bob.equals(bob2)
        && bob.equals(bob2) && bob.equals(bob2));
  }

  @Test
  void nullTest() {
    assertNotEquals(null, bob);
  }

  @Test
  void sameHashcodeTest() {
    persons = new ArrayList<>();
    message = new StringBuilder();
    persons.add(bob);
    persons.add(bob2);
    persons.add(alice);
    persons.add(chris);
    persons.add(radim);
    persons.add(daniel);

    for (int i = 0; i < persons.size(); i++) {
      Person current = persons.get(i);
      Person next = persons.get(i + 1);

      if (!(current.equals(next))
          && current.hashCode() == next.hashCode()) {
        assertNotEquals(current, next);
        assertEquals(current.hashCode(), next.hashCode());

        message.append(current.getName()).append(" not equals ")
            .append(next.getName()).append(" but hashcode equal ")
            .append(current.hashCode()).append(" == ").append(next.hashCode());

        System.out.print(message.toString());
        break;
      }
    }
  }
}