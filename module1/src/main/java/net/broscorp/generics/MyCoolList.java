package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {

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

  public T get(int index) {
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    return (T) objectList[index];
  }

  public Object remove(int index) {
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    System.arraycopy(objectList, index + 1, objectList, index, size-index-1);
    size--;
    return (T) objectList[index];
  }

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

}
