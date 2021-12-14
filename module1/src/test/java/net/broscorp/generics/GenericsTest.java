package net.broscorp.generics;

import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericsTest {

  @Test
  void createDefaultList(){
    MyCoolList<Integer> intList = new MyCoolList<>();
    Assertions.assertEquals(intList.size(), 5);
  }

  @Test
  void addToList(){
    MyCoolList<Integer> intList = new MyCoolList<>(1);
    intList.add(42);
    Assertions.assertEquals(intList.size(), 2);
  }

  @Test
  void getFromList(){
    MyCoolList<Integer> intList = new MyCoolList<>(1);
    intList.add(42);
    Assertions.assertEquals(intList.get(0), 42);
  }

  @Test
  void removeFromList(){
    MyCoolList<Integer> intList = new MyCoolList<>(1);
    intList.add(42);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      intList.remove(1);
    });
  }

  @Test
  void map(){
    MyCoolList<Integer> integerList = new MyCoolList<>(3);
    Function<Integer, Double> intToDouble = integer -> integer.doubleValue();

    integerList.add(22);
    integerList.add(23);
    integerList.add(24);

    MyCoolList<Double> doubleList = integerList.map(intToDouble);

    Assertions.assertEquals(doubleList.get(0), 22.0);
    Assertions.assertEquals(doubleList.get(1), 23.0);
    Assertions.assertEquals(doubleList.get(2), 24.0);
  }

}
