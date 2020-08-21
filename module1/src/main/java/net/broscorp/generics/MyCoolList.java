package net.broscorp.generics;

import java.util.function.Function;
import java.lang.UnsupportedOperationException;

public class MyCoolList {

  public void add(Object o) {
    throw new UnsupportedOperationException();
  }

  public Object get(int index) {
    throw new UnsupportedOperationException();
  }

  public Object remove(int index) {
    throw new UnsupportedOperationException();
  }

  public MyCoolList map(Function f) {
    throw new UnsupportedOperationException();
  }

  public int size() {
    throw new UnsupportedOperationException();
  }

}
