package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private int startLength = 8;
  private Object[] list = new Object[startLength];
  private int size = 0;

  public void add(T obj) {
    if (size == list.length) {
      changeList(list.length * 2);
    }

    list[size++] = obj;
  }

  public Object get(int index) {
    if (index > size) {
      throw new RuntimeException("Out of array length!");
    }
    return list[index];
  }

  public void remove(int index) {
    for (int i = index; i < size; i++) {
      list[i] = list[i++];
    }
    list[size--] = null;
    size--;
    if (list.length > startLength && size < list.length / 3) {
      changeList(list.length / 2);
    }
  }

  /**
   * Method that converted T objects to A objects.
   */
  public <A extends Number> MyCoolList<A> map(Function<T, A> f) {
    MyCoolList<A> secondMyCoolList = new MyCoolList<>();
    for (Object obj : list) {
      if (obj == null) {
        break;
      }
      secondMyCoolList.add(f.apply((T) obj));
    }
    return secondMyCoolList;
  }

  public int size() {
    return size;
  }

  private void changeList(int newLength) {
    Object[] newList = new Object[newLength];
    System.arraycopy(list, 0, newList, 0, size);
    list = newList;
  }

}
