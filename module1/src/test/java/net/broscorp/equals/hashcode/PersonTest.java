package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  public void givenObjectShouldBeEqualsToItself() {
    Person personX = new Person(1,10, "X");

    Assertions.assertTrue(personX.equals(personX));
  }

  @Test
  public void givenEqualObjectsShouldBeEqualToEachOther() {
    Person personX = new Person(1, 10,"X");
    Person personY = new Person(1, 10,"X");
    Person personZ = new Person(1, 10,"X");

    Assertions.assertTrue(personX.equals(personY));
    Assertions.assertTrue(personY.equals(personX));
    Assertions.assertTrue(personY.equals(personZ));
    Assertions.assertTrue(personX.equals(personZ));
  }

  @Test
  public void givenNotNullObjectWhenCompareWithNullShouldReturnFalse() {
    Person personX = new Person(1, 10,"X");

    Assertions.assertFalse(personX.equals(null));
  }

  @Test
  public void hashCodesOfEqualObjectsShouldBeEqual(){
    Person personX = new Person(1, 10,"X");
    Person personY = new Person(1, 10,"X");
    int firstHash = personX.hashCode();
    int secondHash = personY.hashCode();
    Assertions.assertTrue(firstHash == secondHash);
  }

  @Test
  public void findPersonsWithSameHashCodes() {
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
        Assertions.assertEquals(personList.get(iterator).hashCode(), personList.get(iterator + 1).hashCode());
        Assertions.assertNotEquals(personList.get(iterator), personList.get(iterator + 1));
      }
    }
  }
}
