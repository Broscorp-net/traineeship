package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestPerson {

  @Test
  public void similarHashCodeButNotEqual() {
    Person firstPerson = new Person("Ivan", "Ivanovchenko", "15");
    Person secondPerson = new Person("Katya", "Ivanovich", "20");
    assertEquals(firstPerson.hashCode(), secondPerson.hashCode());
    assertNotEquals(firstPerson, secondPerson);
  }

  @Test
  public void similarHashCodeAndEqual() {
    Person firstPerson = new Person("Ivan", "Ivanovchenko", "15");
    Person secondPerson = new Person("Ivan", "Ivanovchenko", "15");
    assertEquals(firstPerson.hashCode(), secondPerson.hashCode());
    assertEquals(firstPerson, secondPerson);
  }

  @Test
  public void listOfPersonsWhichCouldNotBeEqualButWithSimilarHashCode() {
    List<Person> persons = Arrays.asList(new Person("Ivan", "Ivanovchenko", "15"),
        new Person("Katya", "Ivanovich", "20"),
        new Person("Kolya", "Pelmeshkin", "44"),
        new Person("Nika", "Genis", "14"));
    for (int i = 0; i < persons.size() - 1; i++) {
      assertEquals(persons.get(i).hashCode(), persons.get(i + 1).hashCode());
      assertNotEquals(persons.get(i), persons.get(i + 1));
    }
    System.out.print("Here are different persons with similar hashcode (");
    for (Person person : persons) {
      if (person.equals(persons.get(persons.size() - 1))) {
        System.out.print(person + ")");
        break;
      }
      System.out.print(person + ", ");
    }
  }

}
