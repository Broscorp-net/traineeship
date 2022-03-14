package net.broscorp.gcimpl;

import java.util.Map;

import lombok.Getter;

@Getter
public class HeapInfo {

  private Map<String, ApplicationBean> beans;

  public HeapInfo(Map<String, ApplicationBean> beans) {
    this.beans = beans;
  }
}
