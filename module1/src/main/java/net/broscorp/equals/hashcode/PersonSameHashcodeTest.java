package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonSameHashcodeTest {

  public List<Person> people;

  @BeforeEach
  public void initialization() {
    people = new ArrayList<>();
    String personName = "Person";
    int personAge;
    String personEyesColor = "Some color";

    for (int i = 1; i < 50; i++) {
      personAge = (int) (Math.random() * (100 - 1) + 1);
      people.add(new Person(personName + i, personAge, personEyesColor + i));
    }
  }

  @Test
  public void findSameHashcodeTest() {
    for (int i = 0; i < people.size(); i++) {
      for (int j = i + 1; j < people.size(); j++) {
        Person person1 = people.get(i);
        Person person2 = people.get(j);
        if (person1.hashCode() == person2.hashCode()) {
          System.out.println("Вот объект " + person1 
              + ", вот объект " + person2
              + " они разные, но их хэш совпадает");
          assertFalse(person1.equals(person2));
          assertTrue(person1.hashCode() == person2.hashCode());
        }
      }
    }
  }
}