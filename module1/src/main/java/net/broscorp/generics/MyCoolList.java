package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private final List<T> listOfNumbers = new ArrayList<>();

  public void add(T number) {
    listOfNumbers.add(number);
  }

  public T get(int index) {
    return listOfNumbers.get(index);
  }

  public T remove(int index) {
    return listOfNumbers.remove(index);
  }

  /**
   * Method map converts existing type to required.
   * @param f - function
   * @param <R> - required(result) type
   * @return - return
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T number : listOfNumbers) {
      myCoolList.add(f.apply(number));
    }
    return myCoolList;
  }

  public int size() {
    return listOfNumbers.size();
  }
}
