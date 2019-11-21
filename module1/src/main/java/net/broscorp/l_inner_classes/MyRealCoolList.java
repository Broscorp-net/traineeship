import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyRealCoolList<E extends Number> implements Iterable<E> {

    private Number[] elements;
    private int size;

    public int size() {
        return size;
    }

    public MyRealCoolList() {
        elements = new Number[10];
        size = 0;
    }

    public MyRealCoolList(Collection<? extends E> c) {
        elements = (E[]) new Number[c.size()];
        elements = c.toArray(elements);
        size = c.size();
    }

    public void add(E e) {
        int capacity = elements.length;
        if(capacity == size()) {
            elements = Arrays.copyOf(elements, 2 * capacity);
        }

        elements[size()] = e;
        size++;
    }

    public E get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) elements[index];
        }
    }

    public E remove(int index) {
        int capacity = elements.length;
        if(capacity == 2 * size()) {
            int newLength = (int) (2d/3d * capacity);
            elements = Arrays.copyOf(elements, newLength);
        }

        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            for(int i = index; i < size() - 1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return (E) elements[index];
        }
    }

    public MyRealCoolList<? extends Number> map(Function<E, ? extends Number> f) {
        return new MyRealCoolList(
                Stream.of(Arrays.copyOf((E[]) elements, size()))
                        .map(f)
                        .collect(Collectors.toList()));
    }

    @Override
    public Iterator<E> iterator() {
        return new MyRealCoolListIterator();
    }

    /**
     * Статический inner класс:
     *  - имеет доступ только к статическим полям и методам внешнего класса;
     *  - объект не содержит ссылку на объект внешнего класса;
     *  - может содержать статические поля и методы;
     *  - объект может существовать без создания объекта внешнего класса;
     *  - доступен через ИМЯ внешнего класса, например:
     *
     *      OuterClass.StaticInnerClass.method()
     *      или
     *      OuterClass.StaticInnerClass s_innerObject = new OuterClass.StaticInnerClass();
     *
     * Обычный inner класс:
     *  - имеет доступ только ко всеем полям и методам внешнего класса;
     *  - в объект передается неявная ссылка на объект внешнего класса;
     *  - не может содержать статических полей и методов, потому что связан с конкретным объектом внешнего класса;
     *  - объект не может существовать без создания объекта внешнего класса;
     *  - доступен через объект внешнего класса, например:
     *
     *      OuterClass outerObject = new OuterClass();
     *      OuterClass.InnerClass innerObject = outerObject.new InnerClass();
     *
     */
    private class MyRealCoolListIterator implements Iterator<E> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public E next() {
            if(hasNext()) {
                return (E) elements[index++];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if(index > -1 && index <= size()) {
                MyRealCoolList.this.remove(--index);
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
