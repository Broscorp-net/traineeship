package net.broscorp.gc;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GarbageCollectionTest {

  @Test
  public void createABatchOfObjects() {
    //given
    //when
    System.out.println("\n\n====== Creating a lot of objects ======\n\n");
    for (int i = 0; i < 100_000; i++) {
      new SomeObject(i, null, null);
    }
    //then
  }

  @Test
  public void saveObjectReferenceWhileFinalize() {
    //given
    List<SomeObject> list = new ArrayList<>();
    //when
    System.out.println("\n\n====== Creating a lot of objects with an external list ====== \n\n");
    for (int i = 0; i < 200_000; i++) {
      new SomeObject(i, null, list);
    }
    //then
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("LIST SIZE = " + list.size());
    assertFalse(list.isEmpty());
  }

  @Test
  public void objectsReferToEachOther() {
    //given
    //when
    System.out
      .println("\n\n====== Creating a lot of objects with referencing to each other ======\n\n");
    for (int i = 0; i < 100_000; i++) {
      SomeObject firstObject = new SomeObject(i, null, null);
      SomeObject secondObject = new SomeObject(i, null, null);
      firstObject.setObject(secondObject);
      secondObject.setObject(firstObject);
    }
    //then
  }

}
