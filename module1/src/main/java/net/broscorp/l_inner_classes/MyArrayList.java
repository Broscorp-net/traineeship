package net.broscorp.l_inner_classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

class TryArray {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(10);
        myArrayList.add(11);
        myArrayList.add(12);
        System.out.println(myArrayList);
        myArrayList.remove(0);
        System.out.println(myArrayList);
        myArrayList.add(14);
        myArrayList.add(15);
        System.out.println(myArrayList);
        myArrayList.remove(3);
        System.out.println(myArrayList);
        System.out.println("\t" + myArrayList.get(2));

        for (int i = 0; i < 12; i++) {
            myArrayList.add(i*100);
        }
        Iterator<? extends Number> iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

public class MyArrayList<T extends Number> {
    private Object[] elements;
    private Object[] newArray;
    private final int DEFAULT_CAPACITY = 3;
    private int size;

    MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    private void checkCapacity() {
        if (size >= elements.length) {
            grow();
        }
    }

    public boolean add(T o) {
        checkCapacity();
        elements[size++] = o;
        return true;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public T get(int index) {
        if (index > size - 1) {
            System.out.println("Array max index = " + size + ": requesing_" + index);
        }
        return (T) elements[index];
    }

    public void remove(int index) {
        checkCapacity();
        int elemForCopy = elements.length - index - 1;
        if (index > size - 1) {
            System.out.println("Incorrect index: " + index);
            return;
        } else {
            System.arraycopy(elements, index + 1, elements, index, elemForCopy);
        }
        size--;
    }

    public MyArrayList<? extends Number> map(Function<T, ? extends Number> f) {
        MyArrayList<Number> myArrayList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            myArrayList.add(f.apply((T) elements[i]));
        }
        return myArrayList;
    }

    Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor; // индекс для слкдующего элемента
        int lastElem = -1;

        @Override
        public boolean hasNext() {
            return (cursor != size);
        }

        @Override
        public T next() {
            int indx = cursor;
            Object[] elements = MyArrayList.this.elements;
            cursor = indx + 1;
            return (T) elements[lastElem = indx];
        }
    }

    @Override // обрезать элементы с null - значениями
    public String toString() {
        trimToSize();
        return "MyArrayList{" + "elements=" + Arrays.toString(newArray) + '}';
    }

    private void trimToSize() {
        if (size <= elements.length) {
            newArray = (size == 0) ? new Object[0] : Arrays.copyOf(elements, size);
        }
    }
}
