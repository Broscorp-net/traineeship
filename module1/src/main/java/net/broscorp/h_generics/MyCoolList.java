package net.broscorp.h_generics;

import java.util.function.Function;


public class MyCoolList<N extends Number> {

  private MyCoolList next;
  private int index = 0;
  private Object[] arr = new Object[32];


  public void add(N o) {
    if (index == arr.length - 1) {
      Object[] newArray = new Object[arr.length * 2];
      System.arraycopy(arr, 0, newArray, 0, index);
      arr = newArray;
    }
    arr[index++] = o;
  }

  public N get(int index) {
    return (N) arr[index];
  }

  public void remove(int index) {
    for (int i = index; i < this.index; i++) {
      arr[i] = arr[i + 1];
    }
    arr[this.index] = null;
    this.index--;
  }

  public MyCoolList<N> map(Function f) {
    MyCoolList<N> mcl = new MyCoolList<>();
    for (int i = 0; i < index; i++) {
      mcl.add((N) f.apply(arr[i]));
    }
    return mcl;
  }

  public int size1() {
    return index;
  }
}
