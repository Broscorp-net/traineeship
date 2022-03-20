package net.broscorp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private int size = 10;
  private Object[] array = new Object[size];
  private int counter = 0;

  /**
   * Adds elem to the list.
   *
   * @param o - object to add.
   */
  public void add(T o) {
    if (o == null) {
      throw new NullPointerException();
    }
    if (counter >= size - 1) {
      Object[] tempArr = Arrays.stream(array).filter(Objects::nonNull).toArray(Object[]::new);

      this.size *= 2;
      this.array = Arrays.copyOf(tempArr, this.size);
    }
    this.array[counter] = o;
    ++counter;
  }

  /**
   * Gets element by index.
   *
   * @param index - index of the list.
   * @return - element by index.
   */
  public T get(int index) {
    if (index < size - 1) {
      return (T) this.array[index];
    } else if (this.array[index] == null) {
      throw new NoSuchElementException();
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Removes elem by index.
   *
   * @param index - index of the list.
   * @return removed element;
   */
  public T remove(int index) {
    Object temp = this.array[index];

    int nonNullIndex = 0;

    for (int i = index; i < array.length - 1; i++) {
      if (this.array[index] != null) {
        this.array[index] = this.array[index + 1];
      } else {
        nonNullIndex = index - 1;
      }
    }

    this.array[nonNullIndex] = null;

    return (T) temp;
  }

  /**
   * Converts elems of the list according to lambda.
   *
   * @param f - lambda.
   * @param <R> - class type to be converted.
   * @return new list with changed elems.
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();

    List<T> tempList = new ArrayList<>();

    for (int i = 0; i < this.size(); i++) {
      tempList.add((T) this.get(i));
    }

    for (int i = 0; i < tempList.size(); i++) {
      R r = f.apply(tempList.get(i));
      myCoolList.add(r);
    }

    return myCoolList;
  }

  public int size() {
    return (int) Arrays.stream(this.array).filter(Objects::nonNull).count();
  }

  public Iterator<T> iterator() {
    return new MyCoolIterator().iterator();
  }

  /**
   * Статический InnerClass может напрямую обращаться к статическим членам внешнего класса.
   * Но для доступа к членам экземпляра внешнего класса необходимо создать экземпляр внешнего
   * класса.
   * Статическому InnerClass'у не нужна ссылка на внешний класс, но для нестатического
   * InnerClass или обычного InnerClass требуется ссылка на внешний класс. Нестатический
   * InnerClass имеет полный доступ к членам класса, в который он вложен.
   * Статический InnerClass не имеет ссылки на вложенный экземпляр,
   * поэтому статический InnerClass не может
   * вызывать нестатические методы или обращаться к нестатическим полям экземпляра класса, в который
   * он вложен. Ещё одно различие между статическим и нестатическим InnerClass заключается в
   * том, что нельзя получить доступ к нестатическим членам, например: метод и поле во
   * статический InnerClass напрямую.
   * В то время как класс InnerClass имеет доступ как к статическим,
   * так и к нестатическим членам внешнего класса.
   */
  private class MyCoolIterator implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {
        int counter = 0;

        @Override
        public boolean hasNext() {
          return counter < size();
        }

        @Override
        public T next() {
          return get(counter++);
        }
      };
    }
  }
}
