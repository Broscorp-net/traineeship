package net.broscorp.generics;

import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.Function;

public class MyCoolList<T extends Number> extends ArrayList<T> {

  /**
   * I don't understand, why checkstile demands this.
   *
   * @param t only Number supported.
   */
  @Override
  public boolean add(T t) {
    if (isWholeNumber(t)) {
      super.add(t);
      return true;
    }
    return false;
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

  private boolean isWholeNumber(Object o) {
    Number number;
    try {
      number = (Number) o;
    } catch (ClassCastException ex) {
      return false;
    }

    // отсеиваем всех наследников Number, которые не являются целыми числами
    if (number instanceof Float
        || number instanceof Double
        || number instanceof DoubleAccumulator
        || number instanceof DoubleAdder) {
      return false;
    }
    return true;
  }
}
