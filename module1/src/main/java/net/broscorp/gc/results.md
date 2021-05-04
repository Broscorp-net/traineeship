CREATING A LOT OF OBJECTS:
   При выполнении метода вызывается сборщик и удаляет объекты
   без ссылки в Куче. GC вызывается несколько раз, это можно увидеть на графике в
   JConsole.

OBJECTS WITH LINK TO EACH OTHER: 
   Удаляются, так как нет внешних ссылок.

OBJECT RESTORATION: 
   GC не будет удалять объект после восстановления ссылки на него.

LOGS EXAMPLE:
Object net.broscorp.gc.Person@2efa250b deleted by GC
Object net.broscorp.gc.Person@203ddea4 deleted by GC
Object net.broscorp.gc.Person@24024e7b deleted by GC
Object net.broscorp.gc.Person@6100d49f deleted by GC
Object net.broscorp.gc.Person@1e2d67c9 deleted by GC
Object net.broscorp.gc.Person@50ab5256 deleted by GC
Object net.broscorp.gc.Person@666cbfae deleted by GC