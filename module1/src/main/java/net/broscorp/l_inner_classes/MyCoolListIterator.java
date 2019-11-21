package net.broscorp.l_inner_classes;



import java.util.Iterator;
import net.broscorp.h_generics.MyCoolList;



/**
 * Differences between static and non-static inner classes
 * 
 * 1)Static Inner class doesn't need reference of Outer class but Non static Inner class requires
 * Outer class reference. You can not create instance of Inner class without creating instance of
 * Outer class.
 * 
 * 2) Static Inner class is actually static member of class and can be used in static context e.g.
 * static method or static block of Outer class.
 * 
 * 3) Another difference between static and non static Inner classes is that you can not access non
 * static members e.g. method and field into nested static class directly. If you do so you will get
 * error like "non static member can not be used in static context". Non-static inner class has
 * access as well as reference to all fields and functions his Outer Class.
 * 
 * @author
 * @param <E>
 *
 */

public class MyCoolListIterator<E> implements Iterator<E> {


  private MyCoolList<Integer> myList;
  private int index = 0;

  public MyCoolListIterator(MyCoolList<Integer> myList) {
    this.myList = myList;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E next() {
    return (E) myList.get(index++);
  }

  public boolean hasNext() {
    return index < myList.size();
  }

}

