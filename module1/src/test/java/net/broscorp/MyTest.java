package net.broscorp;

import java.util.HashMap;
import java.util.Map;
import net.broscorp.equals.hashcode.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

  @Test
  public void testInvariant() {
    Rectangle rec1 = new Rectangle(2, 5);
    Rectangle rec2 = new Rectangle(2, 5);
    Rectangle rec3 = new Rectangle(2, 6);

    Assertions.assertEquals(rec1, rec2);
    Assertions.assertNotEquals(rec1, rec3);
    Assertions.assertNotEquals(rec2, rec3);
    Assertions.assertEquals(rec1.hashCode(), rec2.hashCode());
    Assertions.assertNotEquals(rec1.hashCode(), rec3.hashCode());
    Assertions.assertNotEquals(rec2.hashCode(), rec3.hashCode());
  }

  @Test
  public void testSameHashcodes() {
    Map<Integer, Rectangle> map = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Rectangle rectangle = new Rectangle(i, j);
        if (map.containsKey(rectangle.hashCode())) {
          System.out.println(
              "Вот объект " + map.get(rectangle.hashCode()) + ", вот объект " + rectangle
                  + ", они разные, но их хеш сопадает");
        } else {
          map.put(rectangle.hashCode(), rectangle);
        }
      }
    }

    Assertions.assertEquals(map.size(), 75);
  }
}