package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import net.broscorp.generics.MyCoolList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Hryhorii Perets
 */
public class MyCoolCollection<E> implements Iterable<E> {

  private Node<E> head;
  private Node<E> tail;


  public void add(E item) {
    Node<E> newNode = new Node<>(item, tail);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }
  }

  public E get(int index) {
    E item = null;
    Iterator<E> iterator = iterator();
    for (int i = 0; i <= index; i++) {
     if (iterator.hasNext()) {
      item = iterator.next();
     }
   }

    return item;
  }

  public E remove(int index) {
    throw new NotImplementedException();
  }

  public MyCoolList map(Function f) {
    throw new NotImplementedException();
  }

  public int size() {
    int size = 0;
    Iterator<E> iterator = iterator();
    while (iterator.hasNext()) {
      iterator.next();
      size++;
    }
    return size;
  }

  public boolean isEmpty() {
    if (this.head == null) {
      return true;
    }
    return false;
  }



  @Override
  public Iterator<E> iterator() {
    return new MyCoolIterator<>(head);
  }

  @Override
  public void forEach(Consumer<? super E> action) {

  }

  @Override
  public Spliterator<E> spliterator() {
    return null;
  }


  private class Node<E> {
    private E item;
    private Node<E> next;

    public Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }

    public E getItem() {
      return item;
    }

    public void setItem(E item) {
      this.item = item;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> next) {
      this.next = next;
    }


  }

  public class MyCoolIterator<E> implements Iterator<E> {

    private Node<E> currentNode;

    public MyCoolIterator(Node<E> currentNode) {
      this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
      if (currentNode != null) {
        return true;
      }
      return false;
    }

    @Override
    public E next() {
      E item = currentNode.getItem();
      currentNode = currentNode.getNext();
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

}
