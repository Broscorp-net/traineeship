package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  List<Person> personList = new ArrayList<>();

  @BeforeEach
  void setUp() {
    personList.add(new Person(1, 26, "Bob", "Uncle"));
    personList.add(new Person(1, 26, "Bob", "Uncle"));
    personList.add(new Person(2, 46, "Bob", "Martin"));
  }

  //3 Написать тест, что проверяет инварианты equals и hashCode из javadoc.
  @Test
  void hashCodesShouldReturnTheSameResult() {
    assertEquals(personList.get(0).hashCode(), personList.get(0).hashCode());
  }

  @Test
  void twoObjectsAreEqualTheirHashCodesAreEqualToo() {
    assertTrue(personList.get(0).equals(personList.get(1)));
    assertEquals(personList.get(0).hashCode(), personList.get(1).hashCode());
  }

  @Test
  void person1EqualsPerson1ShouldReturnTrue() {
    Person person1 = new Person(1, 26, "Bob", "Uncle");
    assertTrue(person1.equals(person1));
  }

  @Test
  void person1EqualsPerson2ShouldReturnTrueIfPerson2EqualsPerson1() {
    Person person1 = new Person(1, 26, "Bob", "Uncle");
    Person person2 = new Person(1, 26, "Bob", "Uncle");
    assertTrue(person1.equals(person2));
    assertTrue(person2.equals(person1));
  }

  @Test
  void person1EqualsPerson2True_Person2EqualsPerson3True_Person1EqualsPerson3ShouldBeTrue() {
    Person person1 = new Person(1, 26, "Bob", "Uncle");
    Person person2 = new Person(1, 26, "Bob", "Uncle");
    Person person3 = new Person(1, 26, "Bob", "Uncle");
    assertTrue(person1.equals(person2));
    assertTrue(person2.equals(person3));
    assertTrue(person1.equals(person3));
  }

  @Test
  void person1EqualsPerson2ShouldReturnTrueOrFalseConsistentlyWhenMultipleInvocations() {
    Person person1 = new Person(1, 26, "Bob", "Uncle");
    Person person2 = new Person(2, 16, "Bob", "Uncle");
    assertFalse(person1.equals(person2));
    assertFalse(person1.equals(person2));
    assertFalse(person1.equals(person2));
  }

  @Test
  void personEqualsNullShouldReturnFalse() {
    Person person = new Person(1, 26, "Bob", "Uncle");
    assertFalse(person.equals(null));
  }

  @Test
  void objectsAreNotEqualButTheirHashCodesAreEqual() {
    personList.add(new Person(2, 32, "John", "Johnson"));
    personList.add(new Person(1, 26, "Bob", "Uncle"));
    personList.add(new Person(2, 32, "John", "Johnson"));
    personList.add(new Person(1, 26, "Bob", "Uncle"));
    personList.add(new Person(6, 23, "David", "Black"));
    for (int i = 0; i < personList.size(); i++) {
      for (int j = i + 1; j < personList.size(); j++) {
        if (!(personList.get(i).equals(personList.get(j))) && ((personList.get(i).hashCode())
            == (personList.get(j).hashCode()))) {
          System.out.println(
              "Person" + i + " " + personList.get(i).hashCode() + " and " + "Person" + j + " "
                  + personList.get(j).hashCode() + " hashCodes are equal");
          assertFalse(personList.get(i).equals(personList.get(j)));
          assertTrue(personList.get(i).hashCode() == personList.get(j).hashCode());
        }
      }
    }
  }
}