package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyCoolList<E extends Number> {

  private List<E> lists = new ArrayList<>();

  public void add(E e) {
    this.lists.add(e);
  }

  public E get(int index) {
    return this.lists.get(index);
  }

  public E remove(int index) {
    return this.lists.remove(index);
  }

  public MyCoolList map(Function f) {


    throw new NotImplementedException();
  }

  public int size() {
    return this.lists.size();
  }

  public List<E> getLists() {
    return lists;
  }

  public void setLists(List<E> lists) {
    this.lists = lists;
  }

}
