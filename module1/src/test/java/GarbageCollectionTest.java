import static org.junit.jupiter.api.Assertions.assertEquals;

import net.broscorp.gc.FirstClass;
import net.broscorp.gc.GarbageCollection;
import net.broscorp.gc.SecondClass;
import net.broscorp.gc.ThirdClass;
import org.junit.jupiter.api.Test;

public class GarbageCollectionTest {
  GarbageCollection gc = new GarbageCollection();

  @Test
  public void gcFirstTest() {
    for (int i = 0; i < 10_000; i++) {
      FirstClass first = new FirstClass(i,"first",i);
      first.counterText();
      SecondClass second = new SecondClass(i,"second",i);
      second.counterText();
      System.gc();
    }
  }

  @Test
  public void gcSecondTest() {
    for (int i = 0; i < 10_000; i++) {
      FirstClass first = new FirstClass(i,"first",i);
      SecondClass second = new SecondClass(i,"second",i);
      first.setEntity(second);
      second.setEntity(first);
      System.gc();
    }
  }

  @Test
  public void gcThirdTest() {
    for (int i = 0; i < 10_000; i++) {
      ThirdClass third = new ThirdClass(i, gc);
      //gc.list.add(third);
      System.gc();
    }
    System.out.println(gc.list.size());
   // assertEquals(10000,gc.list.size());
  }
}
