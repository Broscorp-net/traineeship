package net.broscorp.l_inner_classes;

import java.util.Iterator;
import java.util.function.Function;

public class MyCoolList<T> {

    private final int INIT_SIZE = 10;
    private Object[] array;
    private int size = 0;

    public MyCoolList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new Object[initialCapacity];
        } else if (initialCapacity == 0) this.array = new Object[INIT_SIZE];
        else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public void add(T item) {
        if (size == array.length - 1)
            resize((array.length * 3) / 2 + 1);
        array[size++] = item;
    }
    T elementData(int index) {
        return (T) array[index];
    }

    public T get(int index) {
        return elementData(index);
    }

    public void remove(int index) {
        for (int i = index; i < size; i++)
            array[i] = array[i + 1];
        array[size] = null;
        size--;
    }

    public <R extends Number> MyCoolList<R> map(Function f) {
        MyCoolList<R> result = new MyCoolList<>(size);
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
            if (array[i + 1] == null) {     //!iterable.iterator().hasNext()
                str.append(array[i]);
                break;
            }
            str.append(array[i]).append(", ");
        }
        return str.append("]").toString();
    }

    /**
     * Разница inner_class от static inner_class:
     * 1. Доступ к статическим вложенным классам осуществляется с помощью имени класса
     * ~~MyCoolList.ArrayIterable iterable = new MyCoolList.ArrayIterable();~~
     * А для (обычного) вложенного класса
     * ~~MyCoolList.ArrayIterable iterable = myCoolList.new InnerClass();~~
     * 2. Объект внутреннего класса (inner) не может существовать без объекта «внешнего» класса.
     * Для статических вложенных классов это не так. Объект статического вложенного класса вполне может существовать сам по себе
     * (при создании такого объекта нужно указывать название внешнего класса).
     * 3. Статический вложенный класс может обращаться только к статическим полям внешнего класса.
     * В то время как объекта внутреннего класса есть доступ к переменным «внешнего» класса.
     * 4. Внутренний класс не может содержать статические переменные и методы.
     */

    class ArrayIterable implements Iterable<T> {

        private MyIterator myIterator = new MyIterator();

        @Override
        public Iterator<T> iterator() {
            return myIterator;
        }
    }

    private class MyIterator implements Iterator<T> {
        private T[] arrayList;
        private int currentIndex = 0;

        public MyIterator(){
            this.arrayList = covert(array);
        }

        T[] covert(Object [] arr){
            return (T[]) arr;
        }

        @Override
        public boolean hasNext() {
            return this.currentIndex < size;
        }

        @Override
        public T next() {
            return (T) arrayList[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

