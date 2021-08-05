# Результаты выполнения

## gcGlassTest

Во время выполнения теста, с созданием большого количества объектов, во время выполнения в консоль
начали выводиться сообщения о том, объекты начали удаляться из памяти. Это означает, что Eden память
начала переполняться и был вызван Garbage Collector.

````
...
Glass 213776 was broken.
Glass 214019 was broken.
Glass 214172 was broken.
Glass 214220 was broken.
Glass 214343 was broken.
Glass 214401 was broken.
Glass 214441 was broken.
...
````

Как видно из графика ниже, полученного благодаря присоединению JConsole к процессу, можно увидеть,
как происходил процесс очистки памяти.
<br><br>
![Memory usage statistics](https://i.imgur.com/NosUBOo.png)
<br>
В момент, когда вызвался GC (в этот момент Eden Memory достигла максимального значения и перестала
расти), GC начал отмечать объекты, которые посчитал ненужными в Eden Memory, а создание объектов
продолжилось в Survivor Memory. Это можно понять из следующего участка консольного вывода:

````
Glass 9212477 was broken.
Glass 9560978 was broken.
Glass 9560977 was broken.
Glass 9560976 was broken.
Glass 9560975 was broken.
Object created
Object created
Glass 9560974 was broken.
Glass 9560973 was broken.
Glass 9560972 was broken.
````

Однако, вскоре Survivor memory тоже закончилась. В таком случае, он продолжил создавать объекты в
Old Generation. Как только весь мусор был отмечен для удаления, начался процесс очистки Eden памяти.
Как только память была очищена, ее заполнение продолжилось уже в пуле Eden.

## gcGlassGluedTest

В результате выполнения теста можно увидеть, что несмотря на то, что объект был финализирован, он не
был удален из памяти, ввиду того, что на него ссылалось статическое поле. Поскольку метод finalize()
вызывается сборщиком мусора лишь единожды, то после работы GC он останется в памяти процесса до
конца исполнения программы.

````
Object created
Trying to access 
100500
Finalizing object
Running gc
Glass 100500 was broken.
Glass restored
Trying to access again
100500
````

## gcWildRefGlassTest

После выполнения теста, несложно догадаться, что объекты, которые ссылаются только друг на друга
тоже считаются недоступными и удаляются.

````
Object created
Object created
Glass 2 was broken.
Glass 1 was broken.
````