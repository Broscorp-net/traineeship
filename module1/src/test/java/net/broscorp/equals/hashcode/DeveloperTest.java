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
    Developer firstDeveloper = new Developer("Mike", "Java", 2);
    Developer secondDeveloper = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
    Assertions.assertTrue(secondDeveloper.equals(firstDeveloper));
  }

  @Test
  public void testTransitivityOfEquals() {
    Developer firstDeveloper = new Developer("Mike", "Java", 2);
    Developer secondDeveloper = new Developer("Mike", "Java", 2);
    Developer thirdDeveloper = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
    Assertions.assertTrue(secondDeveloper.equals(thirdDeveloper));
    Assertions.assertTrue(firstDeveloper.equals(thirdDeveloper));
  }

  @Test
  public void testConsistencyOfEquals() {
    Developer firstDeveloper = new Developer("Mike", "Java", 2);
    Developer secondDeveloper = new Developer("Mike", "Java", 2);

    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
    Assertions.assertTrue(firstDeveloper.equals(secondDeveloper));
  }

  @Test
  public void testConsistencyOfEqualsReturnFalse() {
    Developer firstDeveloper = new Developer("Mike", "Java", 2);
    Developer secondDeveloper = new Developer("John", "C++", 3);

    Assertions.assertFalse(firstDeveloper.equals(secondDeveloper));
    Assertions.assertFalse(firstDeveloper.equals(secondDeveloper));
    Assertions.assertFalse(firstDeveloper.equals(secondDeveloper));
    Assertions.assertFalse(firstDeveloper.equals(secondDeveloper));
    Assertions.assertFalse(firstDeveloper.equals(secondDeveloper));
  }

  @Test
  public void testNonNullityOfEquals() {
    Developer developer = new Developer("Mike", "Java", 2);

    Assertions.assertFalse(developer.equals(null));
  }

  @Test
  public void testMultipleInvocationsOfHashcode() {
    Developer developer = new Developer("Mike", "Java", 2);

    int expectedResult = developer.hashCode();

    Assertions.assertEquals(expectedResult, developer.hashCode());
    Assertions.assertEquals(expectedResult, developer.hashCode());
    Assertions.assertEquals(expectedResult, developer.hashCode());
    Assertions.assertEquals(expectedResult, developer.hashCode());
    Assertions.assertEquals(expectedResult, developer.hashCode());
  }

  @Test
  public void testEqualObjectsReturnSameHashcode() {
    Developer firstDeveloper = new Developer("Mike", "Java", 2);
    Developer secondDeveloper = new Developer("Mike", "Java", 2);

    Assertions.assertEquals(firstDeveloper, secondDeveloper);
    Assertions.assertEquals(firstDeveloper.hashCode(), secondDeveloper.hashCode());
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

        System.out.printf("Вот объект %s, вот объект %s, они разные, но их хеш совпадает\n",
            a, b);
        System.out.println(a.hashCode() + " == " + b.hashCode());

        Assertions.assertNotEquals(a, b);
        Assertions.assertTrue(a.hashCode() == b.hashCode());
      }
    }
  }

  @Test
  public void testObjectsWithUniqueHashcode() {
    List<Developer> developers = new ArrayList<>();
    Random random = new Random(100L);

    for (int i = 0; i < 10_000; i++) {
      developers.add(new Developer("Mike", "Java ver." + i, random.nextInt()));
    }

    Map<Integer, List<Developer>> developerMap = developers.stream()
        .collect(Collectors.groupingBy(Developer::hashCode));

    int countObjectsWithUniqueHashcode = 0;

    for (Entry<Integer, List<Developer>> entry : developerMap.entrySet()) {
      List<Developer> developerList = entry.getValue();

      // if list contains only one element, we are sure that hashcode is unique as an object
      if (developerList.size() == 1) {
        countObjectsWithUniqueHashcode++;
      }
    }

    Assertions.assertEquals(10_000, countObjectsWithUniqueHashcode);
  }
}
