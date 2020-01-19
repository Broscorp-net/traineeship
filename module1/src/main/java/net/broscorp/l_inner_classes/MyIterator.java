package net.broscorp.l_inner_classes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

class MyCoolList<N extends Number> implements Iterable<N> {
    private int size = 0;
    private Number[] array;

    public MyCoolList() {
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

    public MyCoolList<? extends Number> map(Function<N, ? extends Number> f) {
        MyCoolList myCoolList = new MyCoolList();
        for (int i = 0; i < this.size; i++) {
            myCoolList.add(f.apply((N) array[i]));
        }
        return myCoolList;
    }

    public int size() {
        return size;
    }

    public Iterator<N> iterator() {
        return new MyIterator<N>();
    }

    private class MyIterator<N> implements Iterator<N> {
        int currentPointer = 0;

        public boolean hasNext() {
            return (currentPointer < size);
        }

        public N next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            N val = (N) array[currentPointer];
            currentPointer++;

            return val;
        }

    }
}





