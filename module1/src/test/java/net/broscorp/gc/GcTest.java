package net.broscorp.gc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GcTest {

  public static DummyDuplicate dummyDuplicate;

  @Test
  public void createObjectAndAfterDeletedObject() {
    for (int i = 0; i < 1000000; i++) {
      Dummy dummy = new Dummy(i);
      dummy = null;
    }
  }

  @Test
  public void createObjectAndAfterDeletedObjectAndUseSystemGc() {
    for (int i = 0; i < 10000; i++) {
      Dummy dummy = new Dummy(i);
      dummy = null;
    }
    System.gc();
  }

  @Test
  public void createTwoObjectHaveLinkOnObject() throws InterruptedException {
    DummyReference1 obj1 = new DummyReference1();
    DummyReference2 obj2 = new DummyReference2();
    obj1.ref = obj2;
    obj2.ref = obj1;

    obj1 = null;
    obj2 = null;

    System.gc();
    Thread.sleep(5000);
  }

  @Test
  public void createObjectAndSaveObjectInFinalize() throws InterruptedException {
    DummyDuplicate dummy = new DummyDuplicate(1);
    dummy = null;
    System.gc();

    Thread.sleep(5000);

    System.out.println(dummyDuplicate);

    Assertions.assertNotNull(dummyDuplicate);
  }
}
