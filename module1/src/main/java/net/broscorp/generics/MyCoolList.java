package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyCoolList<T extends Number> {

  public List<T> listInt;

  public MyCoolList() {
    this.listInt = new ArrayList<>();
  }

  public void add(Object o) {
//    listInt.add(listInt.size(), (Number) o);
  }

  public MyCoolList map(Function f) {
    throw new NotImplementedException();
  }

  public int size() {
    return listInt.size();
  }

  public T get(int index) {
//    if (index >= 0 && index < listInt.size() - 1) {
      return listInt.get(index);
//    }
//    return
  }

  public Object remove(int index) {
    Object removedObject = listInt.get(index);
    listInt.remove(index);
    return removedObject;
  }

}
