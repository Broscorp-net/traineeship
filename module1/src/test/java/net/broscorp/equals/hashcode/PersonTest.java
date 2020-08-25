package net.broscorp.equals.hashcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

  public Person x;
  public Person y;
  public Person z;
  public List<Person> persons = new ArrayList<>();
  public Random random = new Random();

  @BeforeEach
  public void setUp() {
    x = new Person();
    y = new Person();
    z = new Person();
  }

  @Test
  public void xShouldEqualsX() {
    assertEquals(x, x);
  }

  @Test
  public void xShouldEqualsY_AndOnOpposit() {
    assertEquals(x, y);
    assertEquals(y, x);
  }

  @Test
  public void xShouldEqualsY_AndY_ShouldEqualsZ_AndX_ShouldEqualsZ() {
    assertEquals(x, y);
    assertEquals(y, z);
    assertEquals(x, z);
  }

  @Test
  public void X_EqualsY_SoHashcodesShouldBeTheSame() {
    assertTrue(x.hashCode() == y.hashCode());
  }

  @Test
  public void cycleForList() {
    String name = "Name";
    for (int i = 0; i < 1000000; i++) {
      persons.add(new Person(i, random.nextInt(), name + i));
    }
    Map<Integer, List<Person>> personsMap =
        persons.stream().collect(Collectors.groupingBy(Person::hashCode));
    for (Entry<Integer, List<Person>> entry : personsMap.entrySet()) {
      List<Person> personList = entry.getValue();
      for (int i = 0; i < personList.size() - 1; i++) {
        System.out.println(
            "Вот объект "
                + personList.get(i)
                + ", вот объект "
                + personList.get(i + 1)
                + ", они разные, но их хеш совпадает");
        assertEquals(personList.get(i).hashCode(), personList.get(i + 1).hashCode());
        assertNotEquals(personList.get(i), personList.get(i + 1));
      }
    }
  }
}
