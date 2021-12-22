package net.broscorp.gcimpl;

import java.util.HashMap;
import java.util.Map;

public class ApplicationBean {
  private Map<String, ApplicationBean> fieldValues = new HashMap<>();

  public Map<String, ApplicationBean> getFieldValues() {
    return fieldValues;
  }

  public ApplicationBean getChildBean(String beanName) {
    return fieldValues.get(beanName);
  }

  public void addRelation(String fieldName, ApplicationBean relation) {
    fieldValues.put(fieldName, relation);
  }
}
