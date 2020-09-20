package net.broscorp.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> {
  public final List<T> numbers = new ArrayList<>();

  public void add(T number) {
    numbers.add(number);
  }

  public T get(int index) {
    return numbers.get(index);
  }

  public T remove(int index) {
    return numbers.remove(index);
  }

  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> map = new MyCoolList<>();
    for (T number : numbers) {
      map.add(f.apply(number));
    }
    return map;
  }

  public int size() {
    return numbers.size();
  }

}
