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

  public void add(T o) {
    listInt.add(listInt.size(), o);
  }

  public MyCoolList map(Function f) {
    throw new NotImplementedException();
  }

  public int size() {
    return listInt.size();
  }

  /**
   * getting element from ArrayList by index.
   * @param index - index of element.
   * @return element's value or stroke "Wrong index".
   */
  public Object get(int index) {
    try {
      return listInt.get(index);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Wrong index, it should be in the range 0..." + (listInt.size() - 1));
      return "Wrong index";
    }
  }

  /**
   * remove element from ArrayList by index.
   * @param index - index of element.
   * @return removed element or stroke "Wrong index".
   */
  public Object remove(int index) {
    Object removedObject = this.get(index);
    if (removedObject != "Wrong index") {
      listInt.remove(index);
    }
    return removedObject;
  }

}
