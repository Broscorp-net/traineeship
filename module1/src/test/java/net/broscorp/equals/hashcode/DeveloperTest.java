package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

  @Test
  public void testReflexivityOfEquals() {
    Developer developer = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(developer.equals(developer));
  }

  @Test
  public void testSymmetryOfEquals() {
    Developer dev1 = new Developer("Mike", "Java", 2);
    Developer dev2 = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(dev1.equals(dev2));
    Assertions.assertTrue(dev2.equals(dev1));
  }

  @Test
  public void testTransitivityOfEquals() {
    Developer dev1 = new Developer("Mike", "Java", 2);
    Developer dev2 = new Developer("Mike", "Java", 2);
    Developer dev3 = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(dev1.equals(dev2));
    Assertions.assertTrue(dev2.equals(dev3));
    Assertions.assertTrue(dev1.equals(dev3));
  }

  @Test
  public void testConsistencyOfEquals() {
    Developer dev1 = new Developer("Mike", "Java", 2);
    Developer dev2 = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(dev1.equals(dev2));
    Assertions.assertTrue(dev1.equals(dev2));
    Assertions.assertTrue(dev1.equals(dev2));
    Assertions.assertTrue(dev1.equals(dev2));
    Assertions.assertTrue(dev1.equals(dev2));
  }

  @Test
  public void testConsistencyOfEqualsReturnFalse() {
    Developer dev1 = new Developer("Mike", "Java", 2);
    Developer dev2 = new Developer("John", "C++", 3);

    Assertions.assertFalse(dev1.equals(dev2));
    Assertions.assertFalse(dev1.equals(dev2));
    Assertions.assertFalse(dev1.equals(dev2));
    Assertions.assertFalse(dev1.equals(dev2));
    Assertions.assertFalse(dev1.equals(dev2));
  }

  @Test
  public void testNonNullityOfEquals() {
    Developer dev1 = new Developer("Mike", "Java", 2);

    Assertions.assertFalse(dev1.equals(null));
  }

  @Test
  public void testMultipleInvocationsOfHashcode() {
    Developer dev1 = new Developer("Mike", "Java", 2);

    int expectedResult = dev1.hashCode();

    Assertions.assertEquals(expectedResult, dev1.hashCode());
    Assertions.assertEquals(expectedResult, dev1.hashCode());
    Assertions.assertEquals(expectedResult, dev1.hashCode());
    Assertions.assertEquals(expectedResult, dev1.hashCode());
    Assertions.assertEquals(expectedResult, dev1.hashCode());
  }

  @Test
  public void testEqualObjectsReturnSameHashcode() {
    Developer dev1 = new Developer("Mike", "Java", 2);
    Developer dev2 = new Developer("Mike", "Java", 2);

    Assertions.assertEquals(dev1, dev2);
    Assertions.assertEquals(dev1.hashCode(), dev2.hashCode());
  }

  @Test
  public void testObjectsWithEqualHashcode() {
    List<Developer> developers = new ArrayList<>();
    Random random = new Random(100L);

    for (int i = 0; i < 1_000_000; i++) {
      developers.add(new Developer("Mike", "Java ver." + i, random.nextInt()));
    }

    Map<Integer, List<Developer>> developerMap = developers.stream()
        .collect(Collectors.groupingBy(Developer::hashCode));

    for (Entry<Integer, List<Developer>> entry : developerMap.entrySet()) {
      List<Developer> developerList = entry.getValue();

      for (int i = 0; i < developerList.size() - 1; i++) {
        Developer a = developerList.get(i);
        Developer b = developerList.get(i + 1);

        if (a.hashCode() == b.hashCode() && !a.equals(b)) {
          System.out.printf("Вот объект %s, вот объект %s, они разные, но их хеш совпадает\n",
              a, b);
          System.out.println(a.hashCode() + " == " + b.hashCode());

          Assertions.assertNotEquals(developerList.get(i + 1), developerList.get(i));
          Assertions.assertTrue(a.hashCode() == b.hashCode());
        }
      }
    }
  }
}
