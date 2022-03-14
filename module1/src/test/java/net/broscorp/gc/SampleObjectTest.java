package net.broscorp.gc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SampleObjectTest {

  @Test
  public void finalizeTest() {
    SampleObject sampleObject = null;
    for (int i = 0; i < 1000000; i++) {
      sampleObject = new SampleObject();
    }
    Assertions.assertNotNull(sampleObject);
  }

  @Test
  public void resurrectionTest() {
    SampleObjectTwo.reachable = true;

    SampleObjectTwo sampleObjectTwo = new SampleObjectTwo();
    sampleObjectTwo = null;

    for (int i = 0; i < 2; i++) {
      System.gc();
    }
  }

  @Test
  public void referenceTest() {
    SampleObjectThree sampleObjectThree = new SampleObjectThree();
    sampleObjectThree.setOther(new SampleObjectThree());

    sampleObjectThree = null;

    System.gc();
    //both objects are finalized
  }
}
