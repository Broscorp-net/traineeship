import java.util.Iterator;


/**
 *                                 Отичия статического и нестатического внутренних классов
В случае объявления полей и методов члена, нестатические внутренний класс не может иметь статические поля и методы. 
Но в случае статического внутреннего класса могут иметь статические и нестатические поля и методы.

Экземпляр нестатического внутреннего класса создается со ссылкой объекта внешнего класса, в котором он определен, 
это означает, что он имеет охватывающий доступ к полям и методам внешнего класса. В то время как экземпляр 
статического внутреннего класса созданный без ссылки на внешний класс, не имеет такого свойства, кроме статических членов 
внешнего класса.

Нестатический внутренний класс не может объявлять статические поля и статические методы. Он должен быть объявлен как 
в статическом, так и в верхнем уровне. Вы получите эту ошибку, указав, что "статические поля должны быть объявлены только 
в статическом или верхнем уровне".

Нестатический внутренний класс может обращаться как к статическим, так и к нестационарным членам охватывающего класса 
в процедурный стиль получения значения, но не может обращаться к членам статического внутреннего класса.
 * @author adamenko
 *
 */


public class MyCoolListIterator <E extends Number> implements Iterator <E> {

 private MyCoolList<E> myList;
 private int index = 0;
   
  public MyCoolListIterator(MyCoolList<E> myList) {
      this.myList = myList;
  }
  
  
  @Override
  public boolean hasNext() {
    return index < myList.getSize();
  }

  @Override
  public E next() {
   
    return (E)myList.get(index++);
  }

  public static void main(String[] args) {
    MyCoolList <Integer> list = new MyCoolList<>();
    list.add(1); list.add(2); list.add(3); list.add(4);list.add(5);list.add(6);
    MyCoolListIterator<Integer> iterator = new MyCoolListIterator<>(list);
    
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
      }
    
  }
  
}
