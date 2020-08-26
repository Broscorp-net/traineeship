1. При создании множества объектов, которые не содержат ссылки друг на друга(тест 1),
удаление обьекта происходит после создания 54 обьектов каждого класса.

The second object was created 54
The second object was deleted 0
The first object was created 55
The first object was deleted 0

2. При создании множества обьектов, которые содержат ссылки друг на друга (тест 2), удаление все равно происходит, 
так как обьекты не имеют внешних ссылок. 

The second object was created 49
The second object was deleted 0
The first object was created 55
The first object was deleted 0

3. При создании множества обьектов, в которых инициализируется обьект и добавляется в list,
удаление обьектов не происходит.

list.size = 9999;  
