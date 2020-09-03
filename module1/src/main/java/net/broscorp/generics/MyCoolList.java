package net.broscorp.generics;

import java.util.ArrayList;
import java.util.function.Function;

public class MyCoolList<T extends Number> extends ArrayList<T> {

  /**
   * I don't understand, why checkstile demands this.
   * @param t only Number supported.
   */
  @Override
  public boolean add(T t) {
    return  super.add(t);
  }

  @Override
  public T get(int index) {
    return super.get(index);
  }

  @Override
  public T remove(int index) {
    return super.remove(index);
  }

  /**
   * I don't understand, why checkstile demands this.
   */
  public <C extends Number> MyCoolList<C> map(Function f) {
    MyCoolList<C> myCoolList = new MyCoolList<>();
    for (T t : this) {
      myCoolList.add((C) f.apply(t));
    }
    return myCoolList;
  }

  @Override
  public int size() {
    return super.size();
  }
}
