package net.broscorp.equals.hashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEqualsHashCode {

  EqualsHashCode first;
  EqualsHashCode second;

  @BeforeEach
  private void initObjectsForTests() {
    first = new EqualsHashCode(1, "name1");
    second = new EqualsHashCode(1, "name1");

  }

  @Test
  public void testHashcode() {
    Assertions.assertTrue(first.hashCode() == second.hashCode());

    second.setId(100);
    second.setName("1000");

    Assertions.assertFalse(first.hashCode() == second.hashCode());
  }

  @Test
  public void testEquals() {
    Assertions.assertTrue(first.equals(second));

    second.setId(100);
    second.setName("1000");

    Assertions.assertFalse(first.equals(second));
  }

  @Test
  public void objectDoesNotEqualNull() {
    Assertions.assertFalse(first.equals(null));
  }

  @Test
  void findObjectsWithSameHashes() {
    ArrayList<EqualsHashCode> list = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 100_000; i++) {
      list.add(new EqualsHashCode(random.nextInt(), "Entity" + i, "param1" + i));
    }

    Map<Integer, List<EqualsHashCode>> sameHash =
        list.stream().collect(Collectors.groupingBy(EqualsHashCode::hashCode));

    sameHash.forEach((key, value) -> {
      for (int i = 0; i < value.size(); i++) {
        for (int j = value.size() - 1; j > i; j--) {
          if (!value.get(i).equals(value.get(j))) {
            System.out.println(
                "Вот объект " + value.get(i).toString() + ", вот объект " + value.get(j)
                    + ", они разные, но их хеш сопадает");
            Assertions.assertFalse(value.get(i).equals(value.get(j)));
            Assertions.assertTrue(value.get(i).hashCode() == value.get(j).hashCode());
          }
        }
      }
    });
  }
}