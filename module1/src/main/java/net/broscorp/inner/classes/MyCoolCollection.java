package net.broscorp.inner.classes;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyCoolCollection<E> implements Iterable<E> {

  private Node<E> head;
  private Node<E> tail;


  /**
   * Add item in collection.
   * @param item value item's
   */
  public void add(E item) {
    Node<E> newNode = new Node<>(item);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
      tail = newNode;
    }
  }

  /**
   * Return item from collection.
   * @param index value position
   * @return value object's
   */
  public E get(int index) {
    E item = null;
    if (index > -1 && index < size()) {
      Iterator<E> iterator = iterator();
      for (int i = 0; i <= index; i++) {
        if (iterator.hasNext()) {
          item = iterator.next();
        }
      }
      return item;
    }
    throw new IndexOutOfBoundsException();
  }

  /**
   * Delete object from collection.
   * @param index value position
   * @return remote item
   */
  public E remove(int index) {
    E item = null;
    if (index == 0) {
      item = head.item;
      head = head.next;
      return item;
    }

    if (index > 0 && index < size()) {
      Node<E> currentNode = head;
      Node<E> previous = null;
      for (int i = 0; i < index; i++) {
        if (i == index - 1) {
          previous = currentNode;
        }
        if (currentNode.getNext() != null) {
          currentNode = currentNode.next;
        }
      }
      previous.setNext(currentNode.getNext());
      item = currentNode.item;
      return item;
    }
    throw new IndexOutOfBoundsException();
  }

  /**
   * Map object in collection.
   * @param f function (lambda)
   * @return this collection
   */
  public MyCoolCollection<E> map(Function<E, E> f) {
    Iterator<E> iterator = iterator();
    Node<E> currentNode = head;
    while (iterator.hasNext()) {
      currentNode.setItem(f.apply(iterator.next()));
      currentNode = currentNode.next;
    }
    return this;
  }

  /**
   * Return number object in collection.
   * @return size collection
   */
  public int size() {
    int size = 0;
    Iterator<E> iterator = iterator();
    while (iterator.hasNext()) {
      iterator.next();
      size++;
    }
    return size;
  }

  /**
   * Return boolean value if collection is empty.
   * @return false or true
   */
  public boolean isEmpty() {
    return (this.head == null);
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

    public Node(E item) {
      this.item = item;
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

  /**
   * Inner classes — внутренние классы, Non-static nested classes — нестатические вложенные классы.
   *    Объект внутреннего класса не может существовать без объекта «внешнего» класса.
   *    У объекта внутреннего класса есть доступ к переменным «внешнего» класса.
   *    Объект внутреннего класса нельзя создать в статическом методе «внешнего» класса.
   *    Внутренний класс не может содержать статические переменные и методы.
   *    При создании объекта внутреннего класса важную роль играет его модификатор доступа.
   *    Модификаторы доступа для внутренних классов работают так же, как и для обычных переменных.
   * Static nested classes — статические вложенные классы.
   *    Объект статического класса не хранит ссылку на конкретный экземпляр внешнего класса.
   *    Статический вложенный класс может обращаться только к статическим полям внешнего класса.
   *    Объектов, static nested classes, (в отличии от статических переменных, которые существует
   *    в единственном экземпляре) мы можем создать сколько угодно.
   * @param <E> the type elements in the collection
   */
  public class MyCoolIterator<E> implements Iterator<E> {

    private Node<E> currentNode;

    public MyCoolIterator(Node<E> currentNode) {
      this.currentNode = currentNode;
    }

    @Override
    public boolean hasNext() {
      return  (currentNode != null);
    }

    @Override
    public E next() {
      E item = currentNode.getItem();
      currentNode = currentNode.getNext();
      return item;
    }
  }
}
