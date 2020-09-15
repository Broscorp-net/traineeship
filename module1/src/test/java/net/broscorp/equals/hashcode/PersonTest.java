package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  public void personsReflexiveTest() {
    Person person1 = new Person();
    assertEquals(person1, person1);
  }

  @Test
  public void personsSymmetricTest() {
    Person person1 = new Person();
    Person person2 = new Person();
    assertEquals(person1, person2);
    assertEquals(person2, person1);
  }

  @Test
  public void personDoesNotEqualsNull() {
    Person person1 = new Person();
    assertNotEquals(person1, null);
  }

  @Test
  public void personsShouldBeEqualToEachOther() {
    Person person1 = new Person();
    Person person2 = new Person();
    Person person3 = new Person();
    assertEquals(person1, person2);
    assertEquals(person2, person3);
    assertEquals(person1, person3);
  }

  @Test
  public void shouldReturnTrueWhenCompareHashcodesOfEqualPersons() {
    Person person1 = new Person();
    Person person2 = new Person();
    assertTrue(person1.hashCode() == person2.hashCode());
  }

  @Test
  public void findPersonsWitheSameHashcodes() {
    List<Person> persons = new ArrayList<>();
    Random random = new Random();
    String name = "Name";
    for (int iterator = 0; iterator < 1000000; iterator++) {
      persons.add(new Person(iterator, random.nextInt(), name + iterator));
    }
    Map<Integer, List<Person>> personsMap =
        persons.stream().collect(Collectors.groupingBy(Person::hashCode));
    for (Entry<Integer, List<Person>> entry : personsMap.entrySet()) {
      List<Person> personList = entry.getValue();
      for (int iterator = 0; iterator < personList.size() - 1; iterator++) {
        System.out.println(
            "Вот объект "
                + personList.get(iterator)
                + ", вот объект "
                + personList.get(iterator + 1)
                + ", они разные, но их хеш совпадает");
        assertEquals(personList.get(iterator).hashCode(), personList.get(iterator + 1).hashCode());
        assertNotEquals(personList.get(iterator), personList.get(iterator + 1));
      }
    }
  }
}
