package net.broscorp.person;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




public class PersonTest {


  @Test
  void equalsReflexiveTest() {
    Person p = new Person(1,18);
    if (p != null) {
      Assertions.assertTrue(p.equals(p));
    }
  }

  @Test
  void equalsSymmetricTest() {
    Person p1 = new Person(1, 33);
    Person p2 = new Person(1, 33);
    Assertions.assertTrue(p1.equals(p2));
    Assertions.assertTrue(p2.equals(p1));
  }

  @Test
  void equalsTransitiveTest() {
    Person p1 = new Person(1,40);
    Person p2 = new Person(1,40);
    Person p3 = new Person(1,40);
    Assertions.assertTrue(p1.equals(p2));
    Assertions.assertTrue(p2.equals(p3));
    Assertions.assertTrue(p1.equals(p3));
  }

  @Test
  void equalsConsistentTest() {
    Person p1 = new Person(1,90);
    Person p2 = new Person(1,90);
    Assertions.assertTrue(p1.equals(p2));
    Assertions.assertTrue(p1.equals(p2));
    p1.setAge(100);
    Assertions.assertFalse(p1.equals(p2));
  }

  @Test
  void equalsNullValueTest() {
    Person p = new Person(10,100);
    Person pn = null;
    Assertions.assertFalse(p.equals(pn));
  }

  @Test
  void hashCodeMoreThanOnceTest() {
    Person p = new Person(3,400);
    int hc = p.hashCode();
    Assertions.assertEquals(hc,p.hashCode());
  }

  @Test
  void objectAndHashCodeEqualsTest() {
    Person p1 = new Person(8,55);
    Person p2 = new Person(8,55);
    Assertions.assertTrue(p1.equals(p2));
    int hc1 = p1.hashCode();
    int hc2 = p2.hashCode();
    Assertions.assertEquals(hc2,hc1);
  }

  @Test
  void hashCodeWithTwoUnequalObjectsTest() {
    Person p1 = new Person(7,89);
    Person p2 = new Person(8,120);
    Assertions.assertFalse(p1.equals(p2));
    Assertions.assertNotEquals(p1.hashCode(),p2.hashCode());
  }


  @Test
  void findHashTest() {
    Map<Integer,Person> storage = new HashMap<>();
    int count = 1;
    int age = 10;
    while (count < 100000) {
      Person person = new Person(count,age);
      if (storage.containsKey(person.hashCode())) {
        Person tempPerson = storage.get(person.hashCode());
        Assertions.assertNotNull(tempPerson);
        if (!person.equals(tempPerson)) {
          System.out.println("Object person: hash code: " + person.hashCode() + ", with fields: ID "
              + person.getId() + ", Age " + person.getAge()
              + " and object tempPerson with fields: ID " + tempPerson.getId()
              + ", Age " + tempPerson.getAge()
               + "not equals, but have the same hash codes.\n");
        }
      } else {
        storage.put(person.hashCode(),person);
      }
      count++;
      age++;
    }
  }



}