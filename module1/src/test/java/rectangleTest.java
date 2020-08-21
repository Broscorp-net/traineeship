import java.util.ArrayList;
import java.util.List;
import net.broscorp.equals.hashcode.Rectangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class rectangleTest {

  static List<Rectangle> array = new ArrayList<>();

  @BeforeAll
  public static void setList() {
    array.add(new Rectangle(4, 2));
    array.add(new Rectangle(4, 2));
    array.add(new Rectangle(5, 6));
    array.add(new Rectangle(15, 2));
  }

  @Test
  public void equalsHashCodeTest() {

    assertEquals(array.get(0).hashCode(), array.get(1).hashCode());
  }

  @Test
  public void notEqualsHashCodeTest() {

    assertNotEquals(array.get(0).hashCode(), array.get(2).hashCode());
  }

  @Test
  public void equalsTest() {

    assertTrue(array.get(0).equals(array.get(1)));
  }

  @Test
  public void notEqualsTest() {

    assertFalse(array.get(0).equals(array.get(2)));
  }

  @Test
  public void findEqualsHashCodes() {

    for (int i = 0; i < array.size() - 1; i++) {
      Rectangle a = array.get(i);
      Rectangle b = array.get(i + 1);
      if (a.hashCode() == b.hashCode() &&
          !a.equals(b)) {
        System.out.println("Объекты " + a + " и " + b + " разные, но их хэш совпадает.");
      }
    }
  }
}
