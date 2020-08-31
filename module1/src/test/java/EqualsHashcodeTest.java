import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.broscorp.equals.hashcode.MyClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EqualsHashcodeTest {

  static List<MyClass> list = new ArrayList();

  /**
   * In this method generate list of objects.
   */
  @BeforeAll
  public static void setList() {
    list.add(new MyClass(123,"hello", 1234));
    list.add(new MyClass(123,"hello", 1234));
    list.add(new MyClass(123,"hello", 1234));
    list.add(new MyClass(123,"my", 1234));
    list.add(new MyClass(1,"name", 6));
    list.add(new MyClass(2,"is", 5));
    list.add(new MyClass(3,"my", 4));
    list.add(new MyClass(4,"class", 3));
    list.add(new MyClass(5,"everybody", 2));
    list.add(new MyClass(6,"smile", 1));

    Random random = new Random();
    for (int i = 0; i < 10000; i++) {
      list.add(new MyClass(i,"name", random.nextInt()));
    }

  }

  @Test
  public void equalsTest() {
    MyClass first = list.get(0);
    MyClass second = list.get(1);
    MyClass third = list.get(2);

    assertEquals(first, first);
    assertTrue(first.equals(second) && second.equals(first));
    assertTrue(first.equals(second) && second.equals(third) && first.equals(third));
    assertFalse(first == null && second == null && third == null);
  }

  @Test
  public void hashcodeTest() {
    MyClass first = list.get(0);
    MyClass second = list.get(1);
    MyClass third = list.get(2);

    int hash = first.hashCode();
    for (int i = 1; i < 10; i++) {
      assertEquals(hash, first.hashCode());
    }

    assertTrue(first.equals(second));
    assertEquals(first.hashCode(), second.hashCode());
  }

  @Test
  public void notEqualsTest() {
    MyClass first = list.get(0);
    MyClass second = list.get(5);

    assertNotEquals(first, second);
  }

  @Test
  public void notEqualsHashcodeTest() {
    MyClass first = list.get(0);
    MyClass second = list.get(5);

    assertNotEquals(first.hashCode(), second.hashCode());
  }

  @Test
  public void hashcodeEqualsButNotEqualsTest() {
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        if (list.get(i).hashCode() == list.get(j).hashCode()) {
          if (!list.get(i).equals(list.get(j))) {
            System.out.println("Вот объект " + list.get(i) + ", вот объект "
                    + list.get(j) + ", они разные, но их хеш сопадает");
            assertEquals(list.get(i).hashCode(),list.get(j).hashCode());
            assertFalse(list.get(i).equals(list.get(j)));
          }
        }
      }
    }
  }
}
