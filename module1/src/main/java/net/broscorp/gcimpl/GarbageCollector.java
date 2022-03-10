package net.broscorp.gcimpl;

import java.util.List;

public interface GarbageCollector {

  /**
   * Collects the garbage for given application.
   * @param heap application's objects/beans
   * @param stack application's method calls
   * @return list of objects to delete
   */
  List<ApplicationBean> collect(HeapInfo heap, StackInfo stack);

}
