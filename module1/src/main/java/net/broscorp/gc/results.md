// first test:
* Для перевірки виконання GC виконується тест createLotsOfObjects() на створення 100к об'єктів,
* імовірно що при такій кількості об'єктів спрацює GC, який видалить недавно створені об'єкти у довільному порядку,
* що залежить від роботи JVM. Для перевірики спарцювання GC можна перевизнасити метод finalize() 
// first test: sout from finalize() in Asteroid class
  asteroid id = 2 deleted by GC 
  asteroid id = 371 deleted by GC
  asteroid id = 637 deleted by GC
  asteroid id = 736 deleted by GC
  asteroid id = 831 deleted by GC
  asteroid id = 902 deleted by GC
  asteroid id = 980 deleted by GC
  asteroid id = 1069 deleted by GC
  asteroid id = 1188 deleted by GC
  asteroid id = 1272 deleted by GC
  asteroid id = 1356 deleted by GC
* Із логів видно що об'єкти видаляються вибірково
* Jconsole на графіку HeapMemoryUsage відбувається скачок графіка по виділенню пам'яті 
* ![img.png](img.png)
* 
// second test:
* Обєкти які мають посилання на один одного і не мають зовнішніх посилань
* видаляються GC при його виклику 
// second test: sout from both classes
  finalize() in golden asteroid id: 99 - CO
  finalize() in asteroid id:99 - FO
  finalize() in golden asteroid id: 98 - CO
  finalize() in asteroid id:98 - FO
  finalize() in golden asteroid id: 97 - CO
  finalize() in asteroid id:97 - FO
  finalize() in golden asteroid id: 96 - CO
  finalize() in asteroid id:96 - FO
  finalize() in golden asteroid id: 95 - CO
  finalize() in asteroid id:95 - FO
  finalize() in golden asteroid id: 94 - CO
  finalize() in asteroid id:94 - FO

// third test
Оскільки метод finalize запускається один раз для об'єкта, то його можливо "воскресити" його.
Garbage Collector мітить обєкти досяжними, або недосяжними
// third test: sout from finalize() in Asteroid class
"C:\Program Files\Java\jdk-9\bin\java.exe" -ea -Didea.test.cyclic.buffer.size=1048576
"-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.3\lib\idea_rt.jar=55863
:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.2.3\bin" ...

finalize() in golden asteroid id: 0
golden asteroid still 'present'

Process finished with exit code 0
