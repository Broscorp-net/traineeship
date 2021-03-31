package net.broscorp.gcImplementation.model;

import java.util.HashMap;
import java.util.Map;

public class ApplicationBean {

  private BeanType beanType;

  private Map<String, ApplicationBean> childRelations = new HashMap<>();

  public ApplicationBean(BeanType beanType) {
    this.beanType = beanType;
  }

  public BeanType getBeanType() {
    return beanType;
  }

  public Map<String, ApplicationBean> getChildRelations() {
    return childRelations;
  }

  public ApplicationBean getChildBean(String beanName) {
    return childRelations.get(beanName);
  }

  public void addRelation(String fieldName, ApplicationBean relation) {
    childRelations.put(fieldName, relation);
  }
}
