package net.broscorp.generics;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyCoolList<T extends Number> {

  private T[] objectArray;
  private int size;
  private int pointer;
  private static int i;

  /**
   * Constructor.
   */
  public MyCoolList() {
    size = 10;
    pointer = 0;
    objectArray = (T[]) new Number[size];
  }

  /**
   * Add object to list.
   * @param object - object;
   */
  public void add(T object) {
    if (pointer + 1 >= size) {
      size *= 1.5;
      resize(size);
    }
    objectArray[pointer++] = object;

  }

  /**
   * get object by index.
   * @param index - index
   * @return T
   */
  public T get(int index) {
    if (indexTest(index)) {
      return objectArray[index];
    }
    throw new ArrayIndexOutOfBoundsException();
  }

  /**
   * remove method.
   * @param index - index
   */
  public void remove(int index) {
    if (indexTest(index)) {
      T[] tmp = objectArray;
      if (--pointer > index) {
        System.arraycopy(tmp, index, tmp, index - 1, pointer - index);
      }
      tmp[pointer] = null;
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * map method.
   * @param f - function
   * @param <R> - type
   * @return new CoolList
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (int i = 0; i < pointer; i++) {
      T t = objectArray[i];
      myCoolList.add((R) f.apply(t));
    }

    return myCoolList;
  }

  public int size() {
    return pointer;
  }

  private static void returnI() {
    System.out.println(i);
  }

  private void resize(int newSize) {
    objectArray = Arrays.copyOf(objectArray, newSize);
  }

  private boolean indexTest(int index) {
    return index >= 0 && index <= pointer;
  }

  public Iterator<T> iterator() {
    return new MyCoolListIterator();
  }

  /* в Java есть 2 типа вложенных классов:
  * Inner class.
  * Static nested class.
  *
  * Отличия между ними:
  * 1. Static nested class не хранит ссылку на внешний класс.
  * Inner class хранит ссылку на внешний класс.
  * 2. Static nested class может существовать без объекта внешнего класса,но при обращении к нему
  * необходимо указывать внешний класс.
  * Inner class не может существовать без объекта внешнего класса,так же не может быть
  * создан в статическом методе внешнего класса
  * 3. Static nested class может обращаться только к статическим полям и методам внешнего класса.
  * Inner class имеет доступ ко всем полям и методам внешнего класса.
  * 4. Inner class не может содержать статические методы и переменные. Static nested class может
  * содержать статические и нестатические переменные и методы
  *   */

  private class MyCoolListIterator implements Iterator<T> {

    private int elementPointer;

    @Override
    public boolean hasNext() {
      return elementPointer < pointer;
    }

    @Override
    public T next() {
      if (elementPointer >= pointer) {
        throw new NoSuchElementException();
      }
      if (elementPointer >= objectArray.length) {
        throw new ConcurrentModificationException();
      }
      return objectArray[elementPointer++];
    }
  }
}


