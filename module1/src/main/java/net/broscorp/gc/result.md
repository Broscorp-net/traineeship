#Результат выполнения классов

Рассмотрим класс GarbageCollectors и мы увидим, что мы @Override метод finalize().
Который мы сразу-же вызываем, в нём же есть реализация инициализации для объектов GarbageCollectors.
Объекты удаляться не будут, из-за новой инициализации объектов в методе finalize().
Мы создаём 100_000 нулевых объектов этого класса (GarbageCollectors).

```java
public class GarbageCollectors {

  private static GarbageCollectors garbageCollectors = new GarbageCollectors();

  @Override
  protected void finalize() throws Throwable {
    garbageCollectors = this;
    System.out.println("Method 'finalize' was used");
    super.finalize();
  }

  /**Create 100_000 NULL objects.
   *
   * @param args default main args.
   */
  public static void main(String[] args) {
    for (int i = 0; i < 100_000; i++) {
      garbageCollectors = new GarbageCollectors();
      garbageCollectors = null;
    }
    System.gc();
  }
  
}
```

Если рассмотреть классы А и В, то мы увидим в main() реализацию перекрёстного создания объектов.
В этом случае объекты хоть и указывали друг на друга, но по итогу они всё равно будут удалены,
потому что на них не было внешних ссылок из других классов.

```
public static void main(String[] args) {
    for (int i = 0; i < 100_000; i++) {
      FirstClass firstClass = new FirstClass();
      SecondClass secondClass = new SecondClass();
      firstClass.secondClass = secondClass;
      secondClass.firstClass = firstClass;
    }
  }
```