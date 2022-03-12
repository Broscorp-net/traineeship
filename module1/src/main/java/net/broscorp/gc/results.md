Обьекты создаются до того момента когда начинает заканчиваться память.
Потом запускается Garbage Collector, освобождая память.
Обьект после финализации снова можно сделать достижимым.
Обьекты которые ссылаются друг на друга после потери ссылки будут удалены Garbage Collector.

P.S: закоментировал методы finalize и класс GcTest для того чтобы прошла проверка на checkstyle  

Пример логов:

net.broscorp.gc.FirstExample@2315c2e9
net.broscorp.gc.FirstExample@2334f7d
net.broscorp.gc.FirstExample@1c46bbb3
net.broscorp.gc.FirstExample@24f7113d
net.broscorp.gc.FirstExample@29f88dc0
net.broscorp.gc.FirstExample@31a87725
net.broscorp.gc.FirstExample@189ad980
net.broscorp.gc.FirstExample@4f85d57
net.broscorp.gc.FirstExample@69034685
net.broscorp.gc.FirstExample@1be005df
net.broscorp.gc.FirstExample@557899fa
net.broscorp.gc.FirstExample@13ac64e7
net.broscorp.gc.FirstExample@60e82f79
net.broscorp.gc.FirstExample@7bbd0046
net.broscorp.gc.FirstExample@6a9bf182
net.broscorp.gc.FirstExample@1ae03b6a
net.broscorp.gc.FirstExample@3bd24ca8
net.broscorp.gc.FirstExample@28fed4a4
net.broscorp.gc.FirstExample@1ddc27d8
net.broscorp.gc.FirstExample@6fc7462
net.broscorp.gc.FirstExample@2f62cf19
net.broscorp.gc.FirstExample@71e765a5
Finalize method for SecondExample was called
Finalize method for FirstExample was called
Finalize method for SecondExample was called
Finalize method for FirstExample was called
