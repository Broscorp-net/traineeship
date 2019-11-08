1) Создавая большое количество объектов и в то же время удаляя на них ссылку, объекты до определенного количества не убираются GC.
GC начинает убирать объекты без ссылок когда программа уже явно начинает нагружать память.

2) Воскрешение в методе Finalize возможно но нежелательно, так как после воскрешение повторно Finalize уже будет не применим.
Nov 08, 2019 4:25:43 PM Garbage main
INFO: object created
Nov 08, 2019 4:25:43 PM Garbage$CreateObject finalize
INFO: object deleted
Nov 08, 2019 4:25:43 PM Garbage$CreateObject finalize
INFO: object resurrected
Список воскрешенных объектов: [Garbage$CreateObject@3764951d, Garbage$CreateObject@4b1210ee, Garbage$CreateObject@4d7e1886...]

3) Объекты с взаимной ссылкой тоже удаляются, так как GC смотрит не на наличие ссылки у объекта а на достижимость объекта.
