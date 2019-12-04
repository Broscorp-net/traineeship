package net.broscorp.g_value_ref;

import java.util.List;

public class Foo {

  public void foo(int i, List<String> s) {
    s.add("d");
    i += 15;

    System.out.println("Inside foo() -> i = " + i + ", s = " + s);

  }
}
