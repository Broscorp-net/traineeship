package net.broscorp.generics;

import java.util.function.Function;
import java.util.stream.Stream;

public class MyCoolList<T extends Number> {
  //я знаю, что есть негласное правило на счет констант, но я не смог обойти CheckStyle
  private final int defSize = 10;
  private Object[] array = new Object[defSize];
  private int size = 0;

  /**
   * Метод добавляющий T элемент.
   */
  public void add(T element) {
    if (size == array.length) {
      resize(array.length * 2);
    }
    array[size++] = element;
  }

  /**
   * Метод добавляющий T элемент.
   */

  public T get(int index) {
    if (index > size) {
      throw new RuntimeException("Index does not exist");
    }
    return (T) array[index];
  }

  /**
   * Метод удаляющий элемент по индексу.
   */

  public void remove(int index) {
    for (int i = index; i < size; i++) {
      array[i] = array[i + 1];
    }
    array[size - 1] = null;
    size--;
    if (array.length > defSize && size < array.length / 3) {
      resize(array.length / 2);
    }
  }

  /**
   * Метод конвертирующий с T в R объект (числового типа).
   */

  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> result = new MyCoolList<>();
    for (Object ls : array) {
      if (ls == null) {
        break;
      }
      result.add(f.apply((T) ls));
    }
    return result;
  }

  public int size() {
    return size;
  }

  private void resize(int newLength) {
    Object[] newArray = new Object[newLength];
    System.arraycopy(array, 0, newArray, 0, size);
    array = newArray;
  }

  /**
   * Выводит лист на экран.
   */

  public String showList() {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < array.length; i++) {
      if (array[i + 1] == null) {
        str.append(array[i]);
        break;
      }
      str.append(array[i]).append(", ");
    }
    return str.append("]").toString();
  }

}
