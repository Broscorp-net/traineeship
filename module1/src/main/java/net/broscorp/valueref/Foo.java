package net.broscorp.valueref;

import java.util.List;

public class Foo {

  public void foo(int i, List<String> s) {
    s.add("d");
    i += 15;
  }
}
