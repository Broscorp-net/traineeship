import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;

public class MyRealCoolList<E extends Number> {

    private Object[] elems;
    private int size;

    public int size() {
        return size;
    }

    public MyRealCoolList() {
        this.elems = new Object[10];
        this.size = 0;
    }

    public MyRealCoolList(Collection<? extends E> c) {
        this.elems = new Object[c.size()];
        this.size = c.size();

        int i = 0;
        while(i < c.size()) {
            elems[i] = c.iterator().next();
            i++;
        }
    }

    public void add(E e) {
        int capacity = elems.length;
        if(capacity == size()) {
            elems = Arrays.copyOf(elems, 2 * capacity);
        }

        elems[size] = e;
        this.size++;
    }

    public E get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) elems[index];
        }
    }

    public E remove(int index) {
        int capacity = elems.length;
        if(capacity == 2 * size()) {
            int newLength = (int) (2d/3d * capacity);
            elems = Arrays.copyOf(elems, newLength);
        }

        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            for(int i = index; i < size() - 1; i++) {
                elems[i] = elems[i + 1];
            }
            this.size--;
            return (E) elems[index];
        }
    }

    public MyRealCoolList<? extends Number> map(Function<E, ? extends Number> f) {
        MyRealCoolList mappedElems = new MyRealCoolList<>();
        for(int i = 0; i < size(); i++) {
            mappedElems.add(f.apply((E) elems[i]));
        }
        return mappedElems;
    }
}
