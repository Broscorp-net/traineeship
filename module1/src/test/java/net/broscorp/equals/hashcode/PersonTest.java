package net.broscorp.equals.hashcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  void equalsWithDifferentObjects() {
    Person p1 = new Person("John", "Doe", 34);
    Person p2 = new Person("Jake", "Doug", 20);

    assertNotEquals(p1, p2);
  }

  @Test
  void equalsWithIdenticalObjects() {
    Person p1 = new Person("John", "Doe", 34);
    Person p2 = new Person("John", "Doe", 34);

    assertEquals(p1, p2);
  }

  @Test
  void equalsReflexiveness() {
    Person p = new Person("John", "Doe", 34);

    assertEquals(p, p);
  }

  @Test
  void equalsSymmetry() {
    Person p1 = new Person("John", "Doe", 34);
    Person p2 = new Person("John", "Doe", 34);

    assertEquals(p1, p2);
    assertEquals(p2, p1);
  }

  @Test
  void equalsTransitivity() {
    Person p1 = new Person("John", "Doe", 34);
    Person p2 = new Person("John", "Doe", 34);
    Person p3 = new Person("John", "Doe", 34);

    assertEquals(p1, p2);
    assertEquals(p2, p3);
    assertEquals(p1, p3);
  }

  @Test
  void equalsConsistency() {
    Person p1 = new Person("John", "Doe", 34);
    Person p2 = new Person("John", "Doe", 34);
    Person p3 = new Person("Jake", "Baken", 55);

    assertEquals(p1, p2);
    assertNotEquals(p1, p3);
    assertNotEquals(p2, p3);

    assertEquals(p1, p2);
    assertNotEquals(p1, p3);
    assertNotEquals(p2, p3);

    assertEquals(p1, p2);
    assertNotEquals(p1, p3);
    assertNotEquals(p2, p3);
  }

  @Test
  void equalsWithNull() {
    Person p = new Person("Jake", "Baken", 55);

    assertNotEquals(p, null);
  }

  @Test
  void hashCodeConsistency() {
    Person p = new Person("Jake", "Baken", 55);
    int hashCode = p.hashCode();

    assertEquals(hashCode, p.hashCode());
    assertEquals(hashCode, p.hashCode());
    assertEquals(hashCode, p.hashCode());
    assertEquals(hashCode, p.hashCode());
  }

  @Test
  void hashCodeForEqualObjects() {
    Person p1 = new Person("Lucy", "Dorsey", 44);
    Person p2 = new Person("Lucy", "Dorsey", 44);

    assertEquals(p1, p2);
    assertTrue(p1.hashCode() == p2.hashCode());
  }

  @Test
  void distinctObjectsWithIdenticalHashCode() {
    Map<Integer, Person> people = new HashMap<>(2000);
    Person tmpPerson;
    Person personWithIdenticalHash;
    Random rnd = new Random();
    int numOfDuplicateHashCodes = 0;

    for (int i = 1; i < 1000; i++) {
      tmpPerson = createRandomPerson(
          String.valueOf(i),
          1,
          120,
          rnd
      );
      personWithIdenticalHash = people.get(tmpPerson.hashCode());

      if (personWithIdenticalHash != null && !personWithIdenticalHash.equals(tmpPerson)) {
        numOfDuplicateHashCodes++;
        System.out.printf(
            "%s and %s are not equal, but have the same hashcode (%d == %d)\n",
            tmpPerson,
            personWithIdenticalHash,
            tmpPerson.hashCode(),
            personWithIdenticalHash.hashCode()
        );
      } else {
        people.put(tmpPerson.hashCode(), tmpPerson);
      }
    }

    assertTrue(numOfDuplicateHashCodes > 0);
  }

  String repeatString(int times, String str) {
    return new String(new char[times]).replace("\0", str);
  }

  Person createRandomPerson(
      String nameBuildingBlock,
      int lowerAgeBound,
      int upperAgeBound,
      Random rnd
  ) {
    String firstName = repeatString(rnd.nextInt(5) + 1, nameBuildingBlock);
    String lastName = repeatString(rnd.nextInt(5) + 1, nameBuildingBlock);
    return new Person(
        firstName,
        lastName,
        rnd.nextInt(upperAgeBound - lowerAgeBound + 1) + lowerAgeBound);
  }

}
