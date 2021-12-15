package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {


  private static final int DEFAULT_CAPACITY = 5;
  private int size;
  private Object[] objectList;

  public MyCoolList(int capacity){
    if (capacity <= 0){
      throw new IllegalArgumentException();
    }
    objectList = new Object[capacity];
  }

  // constructor that build array of object with default capacity
  public MyCoolList(){
    this(DEFAULT_CAPACITY);
  }

  public void add(T object) {
    resizeArray();
    objectList[size] = object;
    size ++;
  }

  private void resizeArray() {
    if(objectList.length == size){
      Object[] newArray = new Object[objectList.length * 2];
      System.arraycopy(objectList, 0, newArray, 0, size);
      objectList = newArray;
    }
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    return (T) objectList[index];
  }

  @SuppressWarnings("unchecked")
  public Object remove(int index) {
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    System.arraycopy(objectList, index + 1, objectList, index, size-index-1);
    size--;
    return (T) objectList[index];
  }

  @SuppressWarnings("unchecked")
  public <T extends Number> MyCoolList<T> map(Function function) {
    MyCoolList<T> resultList = new MyCoolList<>();
    for(Object _object: objectList){
      if(_object == null) break;
      resultList.add((T) function.apply(_object));
    }
    return resultList;
  }

  public int size() {
    for(int i = 0; i < objectList.length; i++){
      size++;
    }
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new IteratorImplement<>();

  }

  private class IteratorImplement<T> implements Iterator<T>{

    int index = 0;

    @Override
    public boolean hasNext() {
      return index != size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
      if(!hasNext()){
        throw new NoSuchElementException();
      }
      return (T) objectList[index++];
    }

  }
}
/**
 * Внутрішні (вкладені) класи бувають: внутрішні статичні та внутрішні нестатичні.
 * Нестатичні внутрішні класи бувають:
 * -- простий внутрішній класс
 * -- локальний - може бути оголошений всередині методу або блоку інінціалізації
 * -- анонімний - внутрішній клас без імені класу, успадкований від якогось класу.
 * <p>
 * Об'єкт внутрішнього класу неспроможний існувати без об'єкта зовнішнього класу. В об'єкта
 * внутрішнього класу є доступ до методів і полів зовнішнього класу. Навіть до приватних. Але в нього
 * немає доступу до статичних методів та полів зовнішнього класу. Об'єкт внутрішнього класу можна
 * створити у статичному методі зовнішнього класу, але потрібен екземляр зовнішнього класу.
 * <p>
 * Внутрішній клас не може містити статичні змінні та методи. Об'єкт внутрішнього класу може мати усі модифікатори доступу
 * <p>
 * Статичний внутрішній клас:
 * -- об'єкт статичного класу не зберігає посилання на екземпляр зовнішнього класу
 * -- статичний внутрішній клас може звертатися тільки до статичних полів і методів зовнішнього класу
 */