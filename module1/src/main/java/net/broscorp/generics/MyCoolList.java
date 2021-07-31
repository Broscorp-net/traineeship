package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyCoolList {

  public List<? super Number> myList = new ArrayList<>();

  public void add(Number o) {
    myList.add(o);
  }

  public Object get(int index) {
    return myList.get(index);
  }

  public void remove(int index) {
    myList.remove(index);
  }

  public MyCoolList map(Function<Integer, String> f) {
    throw new NotImplementedException();
  }

  public int size() {
    throw new NotImplementedException();
  }
}
