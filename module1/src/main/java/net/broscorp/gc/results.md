При создании большого количества объектов, при заполнении памяти заускается сборщик мусора, 
и начинает удалять объекты, удаление происходит не в том порядке\
в котором создавались эти  объекты.

Create object with id: 24558
Create object with id: 24559
Create object with id: 24560
Create object with id: 24561
Create object with id: 24562
Object with id: 4855 destroyed
Create object with id: 24563
Create object with id: 24564
Create object with id: 24565
Object with id: 4854 destroyed
Create object with id: 24566
Object with id: 4853 destroyed
Create object with id: 24567
Create object with id: 24568
 

Если сделать объект достижимым при финализации то он не удаляется.

Пары объектов ссылающиеся друг на друга тоже удаляются, так как идет не просто подсчет ссылок
 но и проверка на досягаемость объектов.
 Object with name: obj1 destroyed
 Object with name: obj2 destroyed
 Object with name: obj1 destroyed
 Object with name: obj2 destroyed
 
 !PS: finalize() deprecated