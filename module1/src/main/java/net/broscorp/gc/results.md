1. Создание большего количества объектов. 
При выполнении метода вызывается сборщик и удаляет объекты без ссылки в "Heap" jconsole показывает нам на графике ступенчатую зависимость что свидетельствет о нескольких вызовах GC. 

2. Обьекты с ссылками друг на друга. 
Удаляются точно так же как и обьекты без ссылок. 

3. Востановить доступ к объекту перед удалением. 
GC не будет его удалять. 

Пример логов:
finalize called on net.broscorp.gc.ObjectForGarbaCollector@4de2535
finalize called on net.broscorp.gc.ObjectForGarbaCollector@3d98eee7
finalize called on net.broscorp.gc.ObjectForGarbaCollector@3d7392ae
finalize called on net.broscorp.gc.ObjectForGarbaCollector@7fb51f91
finalize called on net.broscorp.gc.ObjectForGarbaCollector@a376adf
finalize called on net.broscorp.gc.ObjectForGarbaCollector@70a252a8
finalize called on net.broscorp.gc.ObjectForGarbaCollector@516558f0
finalize called on net.broscorp.gc.ObjectForGarbaCollector@6fb8cda