package net.broscorp.gcimpl.gc;

import java.util.List;
import java.util.Map;
import net.broscorp.gcimpl.model.ApplicationBean;
import net.broscorp.gcimpl.model.HeapInfo;
import net.broscorp.gcimpl.model.StackInfo;

public interface GarbageCollector {

  List<ApplicationBean> collect(HeapInfo heap, StackInfo stack);

}
