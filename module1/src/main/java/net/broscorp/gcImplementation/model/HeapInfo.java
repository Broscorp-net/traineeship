package net.broscorp.gcImplementation.model;

import java.util.List;
import java.util.Map;

public class HeapInfo {

  private Map<String, ApplicationBean> heap;

  private List<ApplicationBean> expectedGarbage;

  public HeapInfo(Map<String, ApplicationBean> heap, List<ApplicationBean> expectedGarbage) {
    this.heap = heap;
    this.expectedGarbage = expectedGarbage;
  }

  public Map<String, ApplicationBean> getHeap() {
    return heap;
  }

  public List<ApplicationBean> getExpectedGarbage() {
    return expectedGarbage;
  }
}
