import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class MyCoolList<T extends Number> implements Iterable<T> {

  private final List<T> listOfNumbers = new ArrayList<>();

  public void add(T number) {
    listOfNumbers.add(number);
  }

  public T get(int index) {
    return listOfNumbers.get(index);
  }

  public T remove(int index) {
    return listOfNumbers.remove(index);
  }

  /**
   * Method map converts existing type to required.
   *
   * @param f   - function
   * @param <R> - required(result) type
   * @return - return
   */
  public <R extends Number> MyCoolList<R> map(Function f) {
    MyCoolList<R> myCoolList = new MyCoolList<>();
    for (T number : listOfNumbers) {
      myCoolList.add((R) f.apply(number));
    }
    return myCoolList;
  }

  public int size() {
    return listOfNumbers.size();
  }

  /**
   * Существует два типа вложенных класоов - статические(static nested classes) и нестатические(non
   * static) они же внутренние классы.
   *   Статические вложенные классы используются, когда связь между объектом внутреннего и объектом
   * внешнего класса не нужна. Тогда для создания объекта статического внутреннего класса не нужен
   * объект внешнего класса. Также из объекта внутреннего класса нельзя обращаться к нестатическим
   * членам внешнего класса.
   *   Нестатические внутренние классы ведут себя как обычные классы, за исключением того, что их
   * объекты могут быть созданы только внутри внешнего класса. Внутренний класс имеет доступ ко всем
   * полям внешнего класса, в том числе закрытым (с помощью модификатора private). Ссылку на объект
   * внешнего класса из внутреннего можно получить с помощью выражения OuterClass.this. Объекты
   * внутренних классов можно создать только в том классе, в котором они определены. В другом
   * внешнем классе нельзя создать объект внутреннего класса.
   */

  @Override
  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T> {

    private int num = 0;

    @Override
    public boolean hasNext() {
      return num < size();
    }

    @Override
    public T next() {
      num++;
      return get(num - 1);
    }
  }
}
