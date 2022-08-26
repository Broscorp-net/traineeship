_**1. При потере ссылки на обьект, gc срабатывает после вызова finalize(), уничтожая обьекты в 
произвольном порядке. (в консоли вывод части уничтоженных обьектов):**_

First iteration
Second iteration
Obj 282 removed
Obj 1000 removed
Obj 999 removed
Obj 998 removed
Obj 997 removed
Obj 996 removed
Obj 995 removed
Obj 994 removed
Obj 993 removed
Obj 992 removed
....

_**2. При потере обьектом ссылки и его восстановлении - повторно его не получится уничтожить.**_

First iteration
Second iteration
Obj 2 removed

_**3. Если обьекты ссылаются друг на друга, то удаляются 2 обьекта. Однако это происходит 
в случайном порядке, из-за чего могут возникать проблемы**_

First iteration
Second iteration
Obj 1 removed
Obj 2 removed
