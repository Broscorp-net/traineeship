package net.broscorp.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
