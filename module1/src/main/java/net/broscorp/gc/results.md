1. При создании определенного кол-ва обкатов вызывается сборщик мусора после чего происходит удаление этих
   объектов (для меня это 10000 объектов).
   Object number = 5337 is deleted.
   Object number = 5525 is deleted.
   Object number = 5569 is deleted.
   Object number = 5608 is deleted.
2. При вызове System.gc() происходит удаления всех недостижимых объектов.
3. Если в методе finalize() сделать объект достижимым то сборщик мусора его не удалит.
   RestorationWaste number = 9 is not deleted.
   RestorationWaste number = 8 is not deleted.
   RestorationWaste number = 7 is not deleted.
4. Если два объекта ссылаются только друг на друга, то они удаляются.
   WasteReference number = 0 is deleted.
   Waste number = 0 is deleted.