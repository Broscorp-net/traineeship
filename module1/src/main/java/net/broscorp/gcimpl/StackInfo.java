package net.broscorp.gcimpl;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Value;

@Getter
public class StackInfo {
  Deque<Frame> stack = new LinkedList<>();

  public void push(String methodName, ApplicationBean... parameters) {
    stack.push(new Frame(methodName, Arrays.asList(parameters)));
  }

  public Frame pop() {
    return stack.pop();
  }

  @Value
  public class Frame {
    String methodName;
    List<ApplicationBean> parameters;
  }
}
