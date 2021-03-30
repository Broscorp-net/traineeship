package net.broscorp.inner.classes;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import net.broscorp.generics.MyCoolList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Hryhorii Perets
 */
public class MyCoolCollection<E> implements Collection<E> {

  private E data;
  private MyCoolCollection<E> next;
  private MyCoolCollection<E> previous;

  @Override
  public boolean add(Object o) {
    throw new NotImplementedException();
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean addAll(Collection c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public boolean retainAll(Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection c) {
    return false;
  }

  @Override
  public boolean containsAll(Collection c) {
    return false;
  }

  public Object get(int index) {
    throw new NotImplementedException();
  }

  public Object remove(int index) {
    throw new NotImplementedException();
  }

  public MyCoolList map(Function f) {
    throw new NotImplementedException();
  }

  public int size() {
    throw new NotImplementedException();
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public Object[] toArray(Object[] a) {
    return new Object[0];
  }

  public class MyCoolIterator<E> implements Iterator<E> {

    private MyCoolCollection<E> myCoolCollection;


    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public E next() {
      return null;
    }

    @Override
    public void remove() {

    }
  }

}
