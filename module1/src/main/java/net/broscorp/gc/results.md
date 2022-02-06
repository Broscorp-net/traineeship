В методе testCreateManyObjects() создаётся большое колличесто объектов класса Cat, что видно
при просмотре занимаемым приграммой колличества памяти. После очистке хранилища объектов и 
создания новой партии видно как срабатывет GC (выводится соответствующее уведомление);
(Thread.sleep - для демонстриции процесса)  Логи ниже:

0 == START PROGRAM TOTAL MEMORY=13631488
11 AFTER CREATE TOTAL MEMORY=341837824
22 AFTER LOSE TOTAL MEMORY=344983552
0 SIZE_COLLECTION 0
1 == START PROGRAM TOTAL MEMORY=344983552
11 AFTER CREATE TOTAL MEMORY=680001536
GC START IN CAT
GC START IN CAT
GC START IN CAT
22 AFTER LOSE TOTAL MEMORY=678430720
1 SIZE_COLLECTION 0

+++++++++++++++++++++++++++++++++++++++++++++++++++++
В классе GCTest в методе main() демонстрируется поведение GC, если при финализации снова
сделать объект достижимым. Как видно из логов (ниже) ссылка осьается рабочей после того, как
она задействуется

execute method finalize()
object reachable
OBJECT ALIVE 1
execute method finalize()
OBJECT DESTROY 2

+++++++++++++++++++++++++++++++++++++++++++++++++++
В классе TwoLinkTest демонстрируется поведение системы на предмет удаления 2-х объектов,
которые ссылаются друг на друга. Как видно из логов (ниже) GC удаляет указанные объекты
только тогода, когда ссылки на оба из них равны null

net.broscorp.gc.TwoLinkTest@5fd0d5ae
net.broscorp.gc.TwoLinkTest@2d98a335

ONE LINK=null
null
net.broscorp.gc.TwoLinkTest@2d98a335

TWO LINK=null
execute method finalize()
execute method finalize()

null
null