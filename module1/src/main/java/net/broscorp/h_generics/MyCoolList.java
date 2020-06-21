package net.broscorp.h_generics;

import java.util.function.Function;

public class MyCoolList<T extends Number> {
    private final int INIT_SIZE = 10;
    private Object[] array = new Object[INIT_SIZE];
    private int size = 0;

    public void add(T item) {
        if (size == array.length - 1)
            resize(array.length * 2);
        array[size++] = item;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        array[size] = null;
        size--;
    }

    public <R extends Number> MyCoolList<R> map(Function f) {
        MyCoolList<R> result = new MyCoolList<>();
        for (Object ls : array) {
            if (ls == null)
                break;
            result.add((R) f.apply(ls));
        }
        return result;
    }

    public int size() {
        return size;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public String showList() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] == null) {
                str.append(array[i]);
                break;
            }
            str.append(array[i]).append(", ");
        }
        return str.append("]").toString();
    }

}
