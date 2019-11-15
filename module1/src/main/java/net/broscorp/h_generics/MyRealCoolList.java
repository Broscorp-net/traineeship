import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyRealCoolList<E extends Number> extends MyCoolList {

    private List<E> elems;

    public MyRealCoolList() {
        elems = new ArrayList<>();
    }

    @Override
    public void add(Object o) {
        elems.add((E) o);
    }

    @Override
    public Object get(int index) {
        return elems.get(index);
    }

    @Override
    public Object remove(int index) {
        return elems.remove(index);
    }

    @Override
    public Object map(Function f) {
        List<Object> mappedElems = new ArrayList<>();
        for (E elem : elems) {
            mappedElems.add(
                    f.apply(elem)
            );
        }
        return mappedElems;
    }
}
