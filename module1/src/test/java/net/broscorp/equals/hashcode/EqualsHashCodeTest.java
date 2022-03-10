package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsHashCodeTest {

  @Test
  void equalsHashCodeTest() {
    Person tom = new Person("Tom", 15);
    Person tomi = new Person("Tom", 15);
    Person tomy = new Person("tom", 15);
    Assertions.assertTrue(tom.equals(tomi));
    Assertions.assertFalse(tom.equals(tomy));
    Assertions.assertEquals(45,tom.hashCode());
  }

  List<Person> persons = new ArrayList<>();

  {
    persons.add(new Person("Tom", 15));
    persons.add(new Person("Polina", 19));
    persons.add(new Person("John", 5));
    persons.add(new Person("Tomi", 34));
    persons.add(new Person("Tonya", 29));
  }

  @Test
  void hashCodeTest() {
    for (int i = 0; i < persons.size(); i++) {
      for (int j = i + 1; j < persons.size(); j++) {
        if (persons.get(i).hashCode() == persons.get(j).hashCode()) {
          System.out.println("Persons: " + persons.get(i).getName() + " & "
              + persons.get(j).getName() + " have same HashCode = " + persons.get(i).hashCode());
          Assertions.assertEquals(persons.get(i).hashCode(),persons.get(j).hashCode());
        }
      }
    }
  }

  @Test
  void objectEqualsHashCodeTest() {
    for (int i = 0; i < persons.size(); i++) {
      for (int j = i + 1; j < persons.size(); j++) {
        if ((persons.get(i).hashCode() == persons.get(j).hashCode())
            && (!persons.get(i).equals(persons.get(j)))) {
          System.out.println("Вот объект [" + persons.get(i) + "], вот объект ["
              + persons.get(j) + "], они разные, но их хеш совпадает");
          Assertions.assertNotEquals(persons.get(i),persons.get(j));
          Assertions.assertEquals(persons.get(i).hashCode(),persons.get(j).hashCode());
        }
      }
    }
  }

}
