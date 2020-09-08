package net.broscorp.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCoolListTest {

  private Function<Integer, Double> function = Integer::doubleValue;
  private MyCoolList<Integer> integerMyCoolList = new MyCoolList<>();

  @BeforeEach
  public void init() {
    integerMyCoolList.add(7);
  }

  @Test
  public void addTest() {
    integerMyCoolList.add(777);
    assertEquals(2, integerMyCoolList.size());
  }

  @Test
  public void getTest() {
    assertEquals(7, integerMyCoolList.get(0));
  }

  @Test
  public void removeTest() {
    integerMyCoolList.add(13);
    integerMyCoolList.remove(0);
    assertEquals(0, integerMyCoolList.size());
  }

  @Test
  public void mapTest() {
    integerMyCoolList.add(26);
    MyCoolList<Double> list = integerMyCoolList.map(function);
    assertEquals(7.0, list.get(0));
  }

  @Test
  public void sizeTest() {
    assertEquals(1, integerMyCoolList.size());
  }
}
