package net.broscorp.l_inner_classes;

import javafx.scene.control.SelectionMode;

import java.util.Arrays;
import java.util.function.Function;

class TryArray {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
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
        System.out.println(myArrayList.get(2));

    }
}

public class MyArrayList {
    private Object[] elements;
    private Object[] newArray;
    private final int DEFAULT_CAPACITY = 3;
    private int size;

    MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    void chekCapacity() {
        if (size >= elements.length) {
            System.out.println("growing...");
            grow(size);
        }
    }

    public boolean add(Object o) {
        chekCapacity();
        elements[size++] = o;
        return true;
    }

    void grow(int index) {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public Object get(int index) {
        if (index > size - 1) {
            System.out.println("Array max index = " + size + ": requesing_" + index);
        }
        return elements[index];
    }

    public void remove(int index) {
        chekCapacity();
        Object[] temp = elements;
        int elemForCopy = elements.length - index - 1;
        if (index > size - 1) {
            System.out.println("Incorrect index: " + index);
            return;

        } else {
            System.arraycopy(elements, index + 1, elements, index, elemForCopy);
        }
        size--;
    }

    public Object map(Function f) {
        /*public interface Function<T, R> {
         *//**
         * Applies this function to the given argument.
         * @param t the function argument
         * @return the function result
         *//*
            R apply(T t);*/
        return null;
    }

    @Override
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
