Срабатывание Garbage Collector'а начинается после 204_000 итериций по созданию/удалению ссылок на обьекты.

Object 196644 collected by GC <br />
Object 197033 collected by GC <br />
Object 197081 collected by GC <br />
...

При добавлении System.gc() - Garbage Collector срабатывает уже после 48_000 итерация.

Object 25607 collected by GC <br />
Object 27280 collected by GC <br />
Object 27383 collected by GC <br />

Если при финализации опять сделать обьект достижимым, то обьект становится таковым, но стоит отметить, что это срабатывает лишь единожды.

First try to delete object <br />
Object still alive <br />
Second try to delete object <br />
Object killed

При попытке удалить пару обьектов которые ссылаются друг на друга, они успешно удаляются

Object B collected by GC <br />
Object A collected by GC
