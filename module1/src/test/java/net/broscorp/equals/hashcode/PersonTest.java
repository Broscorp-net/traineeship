package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
    daniel = new Person("Daniel", 31,"13276");
  }

  @Test
  void personInvariantTest() {
    // reflexive
    assertTrue(bob.equals(bob));

    // symmetric
    assertTrue(bob.equals(bob2) && bob2.equals(bob));

    // transitive
    assertTrue(bob.equals(bob2) && bob2.equals(bob3)
        && bob.equals(bob3));

    //consistent
    assertTrue(bob.equals(bob2) && bob.equals(bob2)
        && bob.equals(bob2) && bob.equals(bob2));

    // null
    assertFalse(bob.equals(null));
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
      for (int j = 1; j < persons.size(); j++) {
        Person next = persons.get(j);
        if (!current.equals(next)) {
          if (current.hashCode() == next.hashCode()) {
            message.append("current person: ").append(current.getName())
                .append(" not equals ").append("next person: ")
                .append(next.getName()).append(" but hashcode equal ")
                .append(current.hashCode()).append(" == ").append(next.hashCode());
            System.out.println(message.toString());
            break;
          }
        }
      }
    }


  }


}