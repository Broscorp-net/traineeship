* Для перевірки виконання GC виконується тест createLotsOfObjects() на створення 100к об'єктів,
* імовірно що при такій кількості об'єктів спрацює GC, який видалить недавно створені об'єкти у довільному порядку,
* що залежить від роботи JVM
// sout from finalize() in Asteroid class
  asteroid id = 2 deleted by GC )
  asteroid id = 371 deleted by GC )
  asteroid id = 637 deleted by GC )
  asteroid id = 736 deleted by GC )
  asteroid id = 831 deleted by GC )
  asteroid id = 902 deleted by GC )
  asteroid id = 980 deleted by GC )
  asteroid id = 1069 deleted by GC )
  asteroid id = 1188 deleted by GC )
  asteroid id = 1272 deleted by GC )
  asteroid id = 1356 deleted by GC )