# Результаты
В класс GCTeach создается 1 млн объектов с помощью цикла for. 
Переопределен метод finalize(), в котором попеременно вызываются методы разного
вида. 
#####1. При создании большого кол-ва объектов и теряя на них ссылку в цикле:
```
    for (int i = 0; i < 1_000_000; i++) { // create 1 million objects Date()
                gcTeach_1 = new GCTeach();
                gcTeach_2 = new GCTeach();
                //gcTeach_1 = gcTeach_2;
                //gcTeach_2 = gcTeach_1;
                gcTeach_1 = null; // lost link
                gcTeach_2 = null; // lost link
    }
````
срабатывает GC и вызывает метод finalize() у создаваемых объектов (не у всех
, тем самым удаляет их из памяти.

#####2. Если при финализации сделать объект снова достижимым:
```
    public void finalize() {
            gcTeach_1 = this;
            gcTeach_2 = this;
```
То объекты, у которых вызвана финализация не удаляются из памяти.
#####3. Пары объектов, что ссылаются друг на друга:
```
    for (int i = 0; i < 1_000_000; i++) { // create 1 million objects Date()
                gcTeach_1 = new GCTeach();
                gcTeach_2 = new GCTeach();
                gcTeach_1 = gcTeach_2;
                gcTeach_2 = gcTeach_1;
    ...
```
