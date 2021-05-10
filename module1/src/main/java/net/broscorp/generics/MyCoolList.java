package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyCoolList<T extends Number> {

  private List<T> myList = new ArrayList<>();

  /**
   * Adds new element to the list.
   *
   * @param t is parametrized object.
   */
  public void add(T t) {
    myList.add(t);
  }

  /**
   * Gets concrete element from list.
   *
   * @param index is elements index in list.
   * @return element in list by this index.
   */
  public T get(int index) throws IndexOutOfBoundsException {
    return myList.get(index);
  }

  /**
   * Removes concrete element from the list.
   *
   * @param index is elements index in list.
   * @return list without removed element.
   */
  public T remove(int index) throws IndexOutOfBoundsException {
    return myList.remove(index);
  }

  /**
   * Returns int, that means current size of the list.
   *
   * @return size of the list.
   */
  public int size() {
    return myList.size();
  }

  public List<T> getMyList() {
    return myList;
  }

  public void setMyList(List<T> myList) {
    this.myList = myList;
  }

  public MyCoolList<T> map(Function<T, T> function) {
    this.setMyList(myList.stream().map(function).collect(Collectors.toList()));
    return this;
  }

}
