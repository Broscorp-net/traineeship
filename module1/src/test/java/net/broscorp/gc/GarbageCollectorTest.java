package net.broscorp.gc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class GarbageCollectorTest {

  /**
   * Test creates a large number of objects, loses references to objects and makes it possible for
   * gc to remove them.
   */
  @Test
  @Order(1)
  public void checkWorkOfGcOnMultipleObjectsWithoutRefs() {
    for (int i = 1; i <= 10_000; i++) {
      SimplePojo simplePojo = new SimplePojo(String.valueOf(i));
    }
  }

  /**
   * Test creates a large number of objects with alive references to objects during all time while
   * test works and does not allow gc to remove them.
   */
  @Test
  @Order(2)
  public void checkWorkOfGcOnMultipleObjectsWithRefs() {
    List<SimplePojo> list = new ArrayList<>();
    for (int i = 1; i <= 3_000; i++) {
      SimplePojo simplePojo = new SimplePojo(String.valueOf(i));
      list.add(simplePojo);
    }
    System.out.println("SIZE OF LOCAL LIST = " + list.size());
  }

  /**
   * Test creates a large number of pairs of objects with reciprocal references, then loses external
   * references to them and makes it possible for gc to remove them.
   */
  @Test
  @Order(3)
  public void checkWorkOfGarbageCollectorOnMultiplePairsOfObjectsWithReciprocalRefs() {
    for (int i = 1; i <= 10_000; i = i + 2) {
      ReciprocalRefObject reciprocalRefObject1 = new ReciprocalRefObject(String.valueOf(i));
      ReciprocalRefObject reciprocalRefObject2 = new ReciprocalRefObject(String.valueOf(i + 1));
      reciprocalRefObject1.setOtherReciprocalRefObject(reciprocalRefObject2);
      reciprocalRefObject2.setOtherReciprocalRefObject(reciprocalRefObject1);
    }
  }

  /**
   * Test creates a large number of objects, then loses external references to them, but objects get
   * static reference in their method "finalize()" and it does not allow gc to remove them.
   */
  @Test
  @Order(4)
  public void checkWorkOfGcOnMultipleObjectsWithStaticRefInFinalizeMethod() {
    for (int i = 1; i <= 3_000; i++) {
      StaticRefObject staticRefObject = new StaticRefObject(String.valueOf(i));
    }
    System.out.println("SIZE OF STATIC LIST = " + StaticRefObject.staticRefObjectList.size());
  }


  /**
   * Test creates a large number of objects, then loses external references to them, but objects get
   * reference on local variable in their method "finalize() and it does not allow gc to remove
   * them.
   */
  @Test
  @Order(5)
  public void checkWorkOfGcOnMultipleObjectsWithLocalRefInFinalizeMethod() {
    List<PrivateFieldRefObject> localList = new ArrayList<>();
    for (int i = 1; i <= 3_000; i++) {
      PrivateFieldRefObject privateFieldRefObject = new PrivateFieldRefObject(String.valueOf(i),
          localList);
    }
    System.out.println("SIZE OF LOCAL LIST = " + localList.size());
  }
}
