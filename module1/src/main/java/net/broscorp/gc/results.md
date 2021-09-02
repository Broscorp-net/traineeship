1. @Test
     void createDeleteCatsReferences(){ //gc cleaning starts after creating a lot of objects
     for (int i = 0; i <1_000_000 ; i++) {
     Cat cat = new Cat(i);
     cat = null;
     }
     }

Вывод в консоль:
   Cat id 190093 has been destroyed!
   Cat id 190359 has been destroyed!
   ...
   Cat id 194155 has been destroyed!
   Cat id 194272 has been destroyed!

При создании большого колличества объектов с последующим занулением ссылок gc срабатывает гдето на 
170_000 объекте, один раз сработал на 244 объекте

2. @Test
   void createCatsReferencesSysGc(){ //gc cleaning starts earlier
   for (int i = 0; i <1000 ; i++) {
   Cat cat = new Cat(i);
   cat = null;
   }

   System.gc();
   }

Вывод в консоль:
Cat id 0 has been destroyed!
Cat id 139 has been destroyed!
...
Cat id 491 has been destroyed!
Cat id 490 has been destroyed!
Cat id 489 has been destroyed!
Cat id 488 has been destroyed!

При создании большого колличества объектов с последующим занулением ссылок и вызовом команды 
System.gc(), gc срабатывает практически сразу но не всегда с первого объкта, обычно со 140

3. при финализации делаем объект достижимым
static Cat REF; //initialization in finalize method

@Test
void makeObjectReachableAgain(){
Cat cat = new Cat(1);

    cat = null;

    System.gc(); //gc cleans cat with id 1

    REF = null;

    System.gc();//gc do not clean cat with id 1, gc cleans the same object only once
}

public class Cat {

private int id;

public Cat() {
}

public Cat(int id) {
this.id = id;
}

@Override
protected void finalize() throws Throwable {
CatGcTest.REF = this;
System.out.println("Cat id " + id + " has been destroyed!");
}
}

Вывод в консоль:
Cat id 1 has been destroyed!
Process finished with exit code 0

При уборке мусора объект который был однажды удален повторно не удаляется

4.будут ли удалены пары объектов, которые ссылаются друг на друга

public class Cat {
public Cat friend;
private int id;
public Cat() {
}
public Cat(int id) {
this.id = id;
}
@Override
protected void finalize() throws Throwable {
    System.out.println("Cat id " + id + " has been destroyed!");
}
}

public class Main {

public static Cat REFERENCE;

public static void main(String[] args) {
Cat cat1 = new Cat(1);
    Cat cat2 = new Cat(2);
    cat1.friend = cat2;
    cat2.friend = cat1;
    cat1 = null;
    cat2 = null;
    System.gc();
}
}
Вывод в консоль:
Cat id 2 has been destroyed!
Cat id 1 has been destroyed!

Удаление произойдет при более глубокой чистке, так как к вышеописанным объектам нету доступа из 
текущего кода