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

  private Person person1 = new Person();
  private Person person2 = new Person();
  private Person person3 = new Person();
  private List<Person> persons = new ArrayList<>();
  private Random random = new Random();

  @Test
  public void person1ShouldEqualsPerson1() {
    assertEquals(person1, person1);
  }

  @Test
  public void person1ShouldEqualsPerson2AndOnOpposit() {
    assertEquals(person1, person2);
    assertEquals(person2, person1);
  }

  @Test
  public void person1ShouldEqualsPerson2Person2ShouldEqualsPerson3AndPerson1ShouldEqualsPerson3() {
    assertEquals(person1, person2);
    assertEquals(person2, person3);
    assertEquals(person1, person3);
  }

  @Test
  public void person1EqualsPerson2SoHashcodesShouldBeTheSame() {
    assertTrue(person1.hashCode() == person2.hashCode());
  }

  @Test
  public void cycleForList() {
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
