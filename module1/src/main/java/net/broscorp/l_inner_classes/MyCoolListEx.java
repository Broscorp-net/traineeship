package net.broscorp.l_inner_classes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 *К статическому - иннер классу есть доступ у всей программы, он не имеет доступ к
 *                 не статическим методам и не к полям обрамляющего его класс
 *                 (можно получить доступ через объявление класса)
 *
 * Не статический - имеет доступ ко всем полям и методам обрамляющего его класса, ко внутренним классам
 *                  есть доступ только у обрамляющего его класс.
 *                  Не может иметь статических полей и методов так как он неявно связан с
 *                  объектом своего внешнего класса.
 *                  Внутренний класс может быть объявлен внутри метода или блока инициализации.
 */

public class MyCoolListEx<N extends Number> implements Iterator<N> {

  private MyCoolListEx next;
  private int index =0;
  private Object[] arr = new Object[32];
  private int iter = 0;

  public void add(N o){
    if (index == arr.length-1)
    {
      Object[] newArray = new Object[arr.length*2];
      System.arraycopy(arr, 0, newArray, 0, index);
      arr = newArray;
    }
    arr[index++] = o;
  }

  public N get(int index){
    return (N)arr[index];
  }

  public void remove(int index){
    for (int i = index; i<this.index; i++)
      arr[i] = arr[i+1];
    arr[this.index] = null;
    this.index--;
  }

  public MyCoolListEx map(Function f) {
    MyCoolListEx<N> mcl = new MyCoolListEx<>();
    for (int i = 0; i < index; i++){
      mcl.add((N) f.apply(arr[i]));
    }
    return mcl;
  }

  @Override
  public boolean hasNext() {
    return iter < index;
  }

  @Override
  public N next() {
    if (iter <index){
      return  (N)  arr[iter++];
    }else {
      throw new NoSuchElementException();
    }
  }
}
