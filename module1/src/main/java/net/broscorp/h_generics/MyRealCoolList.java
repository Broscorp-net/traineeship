import java.util.Arrays;
import java.util.function.Function;

public class MyRealCoolList<E extends Number> extends MyCoolList {

    private Object[] elems;
    private int size;

    public int size() {
        return size;
    }

    public MyRealCoolList() {
        this.elems = new Object[10];
        this.size = 0;
    }

    @Override
    public void add(Object o) {
        int capacity = elems.length;
        if(capacity == size()) {
            elems = Arrays.copyOf(elems, 2 * capacity);
        }

        elems[size] = (E) o;
        this.size++;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return elems[index];
        }
    }

    @Override
    public Object remove(int index) {
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
            return elems[index];
        }
    }

    @Override
    public Object map(Function f) {
        MyRealCoolList<? extends Number> mappedElems = new MyRealCoolList<>();
        for(int i = 0; i < size(); i++) {
            mappedElems.add(f.apply(elems[i]));
        }
        return mappedElems;
    }
}
