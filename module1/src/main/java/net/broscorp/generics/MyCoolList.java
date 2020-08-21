package net.broscorp.generics;

import java.lang.UnsupportedOperationException;
import java.util.function.Function;

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
