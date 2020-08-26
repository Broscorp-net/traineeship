import java.util.function.Function;
import net.broscorp.generics.MyCoolList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCoolListTest {

  private static MyCoolList<Integer> list = new MyCoolList<>();
  private Function<Integer, Double> function = integer -> integer.doubleValue();

  @BeforeAll
  public static void setList() {
    for (int i = 0; i < 10; i++) {
      list.add(i + 10);
    }
  }

  @Test
  public void addTest() {

    list.add(3);
    assertEquals(3, list.get(list.size() - 1));
    list.remove(list.size() - 1);
  }

  @Test
  public void getTest() {

    assertEquals(10, list.get(0));
  }

  @Test
  public void removeTest() {

    list.remove(0);
    assertEquals(11, list.get(0));

  }

  @Test
  public void mapTest() {
    MyCoolList<Double> list1 = list.map(function);

    for (int i = 0; i < list1.size(); i++) {
      assertTrue(list1.get(i) instanceof Double);
    }

  }

  @Test
  public void sizeTest() {
    assertEquals(10, list.size());
  }

}
