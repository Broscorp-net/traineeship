package net.broscorp.hashcode;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.equals.hashcode.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

  private static final List<Person> persons = new ArrayList<>();

  static {
    persons.add(new Person("John", "Smith", 30));
    persons.add(new Person("John", "Smith", 30));
    persons.add(new Person("Fred", "Derf", 30));
    persons.add(new Person("Derf", "Fred", 30));
  }

  @Test
  public void checkEqualsAndHashCode() {
    Assertions.assertEquals(persons.get(0), persons.get(1));
    Assertions.assertNotEquals(persons.get(0), persons.get(2));
  }

  @Test
  public void foundIdenticalHashCode() {
    Assertions.assertEquals(persons.get(0).hashCode(), persons.get(1).hashCode());
  }

  @Test
  public void foundDifferentObjectWithIdenticalHashCode() {
    Assertions.assertEquals(persons.get(2).hashCode(), persons.get(3).hashCode());
    Assertions.assertNotEquals(persons.get(2), persons.get(3));

    System.out.print("Вот объект " + persons.get(2).toString() + ", вот объект "
        + persons.get(3).toString() + ", они разные, но их хеш совпадает");
  }
}
