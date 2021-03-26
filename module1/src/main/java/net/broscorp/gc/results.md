##Creating a large number of objects 
   При выполнении метода вызывается сборщик и удаляет объекты
   без ссылки в Heap(Куче). GC вызывается несколько раз, этому свидетельствует ступенчетый график в
   JConsole.
   
##Object with links to each other 
   Удаляются точно так же как и обьекты без ссылок, так как они не содержат внешних ссылок.

##Object restoration 
   GC не будет его удалять.

###Example logs:
finalize called on net.broscorp.gc.GarbageColl@6aba3833 
finalize called on net.broscorp.gc.GarbageColl@7ddcbe10
finalize called on net.broscorp.gc.GarbageColl@5a787d5d
finalize called on net.broscorp.gc.GarbageColl@75950a0 
finalize called onnet.broscorp.gc.GarbageColl@3c199bd8 
finalize called on net.broscorp.gc.GarbageColl@242d9e75
finalize called on net.broscorp.gc.GarbageColl@3d268d38