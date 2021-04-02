package net.broscorp;

import java.util.ArrayList;
import java.util.List;
import net.broscorp.gc.Address;
import net.broscorp.gc.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  void loseLink() {
    System.out.println("start1");
    for (int i = 0; i < 99999; i++) {
      new Person("name" + i, 2);
    }
    System.out.println();
    System.out.println("finish1");
  }

  @Test
  void checkLostObjects() {
    System.out.println();
    System.out.println("Size:" + Person.people.size());
    System.out.println("first person name: " + Person.people.get(0).getName());
  }

  @Test
  void loseLinkWithAnotherLink() {
    System.out.println("start2");
    for (int i = 0; i < 99999; i++) {
      Address address = new Address("street" + i);
      Person person = new Person("name" + i, 2);
      person.setAddress(address);
      address.setPerson(person);
    }
    System.out.println();
    System.out.println("finish2");
  }

}