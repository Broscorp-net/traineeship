package net.broscorp.h_generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

public class MyOwnCoolList<N extends Number> {
    private int size = 0;
    private Number[] array;

    public MyOwnCoolList() {
        this.array = new Number[10];
        this.size = 0;
    }

    public void add(N item) {
        if (array.length - size <= 5) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = item;
    }

    public N get(int index) {
        return (N) Array.get(array, index);
    }

    public N remove(int index) {
        if (index < size) {
            Number obj = array[index];
            array[index] = null;
            int tmp = index;
            while (tmp < size) {
                array[tmp] = array[tmp + 1];
                array[tmp + 1] = null;
                tmp++;
            }
            size--;
            return (N) obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public MyOwnCoolList<? extends Number> map(Function<N, ? extends Number> f) {
        MyOwnCoolList myOwnCoolList = new MyOwnCoolList();
        for (int i = 0; i < this.size; i++) {
            myOwnCoolList.add(f.apply((N) array[i]));
        }
        return myOwnCoolList;
    }

    public int size() {
        return size;
    }

}
