package net.broscorp.gcImplementation.gc;

import java.util.List;
import java.util.Map;
import net.broscorp.gcImplementation.model.ApplicationBean;

public interface GarbageCollector {

  List<ApplicationBean> collect(Map<String, ApplicationBean> heap);

}
