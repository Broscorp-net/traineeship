package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  public void creatingALotOfObjects() {
    for (int i = 0; i < 100_000; i++) {
      new Person().setPerson(new Person());
    }
  }

  @Test
  public void creatingALotOfObjectsWithLinkToEachOther() {
    for (int i = 0; i < 100_000; i++) {
      Person firstPerson = new Person();
      Person secondPerson = new Person();

      firstPerson.setPerson(secondPerson);
      secondPerson.setPerson(firstPerson);
    }
  }

  @Test
  public void creatingALotOfObjectsAndRestoringRef() {
    List<Person> persons = new ArrayList<>();
    for (int i = 0; i < 100_000; i++) {
      Person person = new Person();
      persons.add(person);
    }
    System.out.println("Size of the list:" + persons.size());
  }
}
