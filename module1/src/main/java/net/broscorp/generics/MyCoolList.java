package net.broscorp.generics;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private class Node {
    private T data;
    private Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node root;
  private Node tail;
  private int size;

  /**
   * Appends element to the end of the list.
   * @param elem Element to append
   */
  public void add(T elem) {
    if (!hasEnoughSpace()) {
      return;
    }

    if (root == null) {
      root = new Node(elem);
      tail = root;
      size++;

      return;
    }

    tail.next = new Node(elem);
    tail = tail.next;
    size++;
  }

  /**
   * Returns the element at the specified position in this list.
   * @param index index of the element to return
   * @return the element at the specified position in this list
   */
  public T get(int index) {
    rangeCheck(index);

    if (index == size - 1) {
      return tail.data;
    }

    Node currNode = root;

    while (index > 0) {
      currNode = currNode.next;
      index--;
    }

    return currNode.data;
  }

  /**
   * Removes the element at the specified position in this list.
   * Shifts any subsequent elements to the left.
   * @param index the index of the element to be removed
   * @return the element that was removed from the list
   */
  public T remove(int index) {
    rangeCheck(index);

    int counter = index;

    if (index == 0) {
      if (size == 1) {
        tail = null;
      }

      Node removedNode = root;
      root = root.next;

      size--;
      return removedNode.data;
    }

    Node currNode = root;

    while (counter > 1) {
      currNode = currNode.next;
      counter--;
    }

    final Node removedNode = currNode.next;
    currNode.next = currNode.next.next;
    if (index == size - 1) {
      tail = currNode;
    }

    size--;
    return removedNode.data;
  }

  /**
   * Returns a MyCoolList consisting of the results of applying the given function to the
   * elements of this list.
   * @param f function to apply to each element
   * @param <R> The element type of the new list
   * @return the new list
   */
  public <R extends Number> MyCoolList<R> map(Function<T, R> f) {
    MyCoolList<R> newList = new MyCoolList<>();

    if (f == null) {
      return newList;
    }

    Node currNode = root;

    while (currNode != null) {
      newList.add(f.apply(currNode.data));
      currNode = currNode.next;
    }

    return newList;
  }

  public int size() {
    return size;
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
  }

  private boolean hasEnoughSpace() {
    return size < Integer.MAX_VALUE;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node currNode = root;

    sb.append("[ ");
    for (int i = 0; i < size; i++) {
      sb.append(currNode.data).append(' ');
      currNode = currNode.next;
    }
    sb.append("]");

    return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
    return new MyCoolListIterator();
  }

  @Override
  public void forEach(Consumer<? super T> consumer) {
    Objects.requireNonNull(consumer);

    Node currNode = root;
    int counter = 0;

    while (counter < this.size) {
      consumer.accept(currNode.data);
      currNode = currNode.next;
      counter++;
    }
  }

  private class MyCoolListIterator implements Iterator<T> {

    private Node currNode;
    private int cursor;
    private int lastRet = -1;

    public MyCoolListIterator() {
      currNode = root;
    }

    @Override
    public void remove() {
      if (this.lastRet < 0) {
        throw new IllegalStateException();
      } else {
        MyCoolList.this.remove(this.lastRet);
        this.cursor = this.lastRet;
        this.lastRet = -1;
      }
    }

    @Override
    public boolean hasNext() {
      return this.cursor != size;
    }

    @Override
    public T next() {
      if (this.cursor >= size) {
        throw new NoSuchElementException();
      } else {
        T data = this.currNode.data;
        this.lastRet = this.cursor++;
        this.currNode = this.currNode.next;
        return data;
      }
    }

  }

}
