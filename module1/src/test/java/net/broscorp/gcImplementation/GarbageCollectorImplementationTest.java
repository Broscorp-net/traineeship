package net.broscorp.gcImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import net.broscorp.gcImplementation.gc.GarbageCollector;
import net.broscorp.gcImplementation.model.ApplicationBean;
import net.broscorp.gcImplementation.model.HeapInfo;
import net.broscorp.gcImplementation.process.Application;
import org.junit.jupiter.api.Test;

class GarbageCollectorImplementationTest {

  private final Application application = new Application();

  private final GarbageCollector gc = null;

  @Test
  public void unlinkedObjectsCollectionTest() {

    // WITH
    final HeapInfo heapInfo = application.getSimpleHeapSnapshot();

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo.getHeap());

    // THEN
    assertEquals(heapInfo.getExpectedGarbage().size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(heapInfo.getExpectedGarbage()));
  }

  @Test
  public void boundedSubChildCollectionTest() {

    // WITH
    final HeapInfo heapInfo = application.getBoundedChildHeapSnapshot();

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo.getHeap());

    // THEN
    assertEquals(heapInfo.getExpectedGarbage().size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(heapInfo.getExpectedGarbage()));
  }

  @Test
  public void multiRootCollectionTest() {

    // WHEN
    final HeapInfo heapInfo = application.getMultiRootHeapSnapshot();

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo.getHeap());

    // THEN
    assertEquals(heapInfo.getExpectedGarbage().size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(heapInfo.getExpectedGarbage()));
  }


  @Test
  public void crossRootCollectionTest() {

    // WHEN
    final HeapInfo heapInfo = application.getCrossRootBoundedHeapSnapShot();

    // WHEN
    final List<ApplicationBean> actualGarbage = gc.collect(heapInfo.getHeap());

    // THEN
    assertEquals(heapInfo.getExpectedGarbage().size(), actualGarbage.size());
    assertTrue(actualGarbage.containsAll(heapInfo.getExpectedGarbage()));
  }
}