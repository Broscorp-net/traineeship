package net.broscorp.generics;

import java.util.function.Function;

public class MyCoolList {

  private int curr = -1; // -1 for non initialized array (has no elements)
  private Object[] arr = null; // null for non initialized array (has no elements)

  /**
   * Add object o to the collection.
   * @param o - object to add to the collection.
   */
  public void add(Object o) {
    if (arr != null && this.curr <= this.arr.length - 2) {
      this.arr[++this.curr] = o;
    } else {
      this.increaseArray();
      this.add(o);
    }
  }

  private void increaseArray() {
    if (this.arr == null) { // initialize array with size 1
      this.arr = new Object[1];
    } else { // double array size and copy elements

      // TBD: add check if newLength becomes greater than MAX_INTEGER

      int newLength = this.arr.length * 2;
      Object[] arrTmp = this.arr;
      this.arr = new Object[newLength];
      System.arraycopy(arrTmp, 0, arr, 0, arrTmp.length - 1 + 1);
    }
  }

  /**
   * Fetches the element at position index.
   * @param index - posotion to fetch the element
   * @return the fetched element
   */
  public Object get(int index) {

    if (isValidIndex(index)) {
      return this.arr[index];
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Removes element at position index.
   * @param index - position of the element to be removed.
   * @return the removed element.
   */
  public Object remove(int index) {

    if (isValidIndex(index)) {
      Object o = this.get(index);

      if (this.arr.length - index >= 0) {
        System.arraycopy(this.arr, index + 1, this.arr, index, this.arr.length - index);
      }
      this.curr--;
      return o;
    } else {
      throw new IllegalArgumentException();
    }
  }

  private boolean isValidIndex(int index) {
    if (this.arr == null) {
      return false;
    } else {
      return index >= 0 && index <= this.curr;
    }
  }

  public MyCoolList map(Function f) {
    throw new UnsupportedOperationException();
  }

  public int size() {
    return this.curr + 1;
  }
}
