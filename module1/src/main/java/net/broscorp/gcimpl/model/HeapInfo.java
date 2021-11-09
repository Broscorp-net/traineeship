package net.broscorp.gcimpl.model;

import lombok.Getter;

import java.util.Map;

@Getter
public class HeapInfo {

  private Map<String, ApplicationBean> beans;

  public HeapInfo(Map<String, ApplicationBean> beans) {
    this.beans = beans;
  }
}
