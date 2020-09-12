import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.Test;

class MyCoolListTest {
  MyCoolList<Integer> list = new MyCoolList<>();
  Function<Integer, Double> func = x -> x + 10.0;

  @Test
  public void add() {
    list.add(5);
    assertEquals(5,list.get(list.size() - 1));
  }

  @Test
  public void get() {
    list.add(5);
    assertEquals(5, list.get(0));
  }

  @Test
  public void remove() {
    list.add(5);
    list.remove(0);
    assertTrue(list.size() == 0);
  }

  @Test
  public void map() {
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    MyCoolList<Double> mapList = list.map(func);
    assertTrue(mapList.get(0) instanceof Double);
  }

  @Test
  public void size() {
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    assertTrue(list.size() == 10);
  }
}