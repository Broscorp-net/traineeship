
Закомментировал finalize методы, потому что ругается checkstyle plugin.

1. При создании 1 000 обьектов Сборщик мусора не запустился. Программа завершилась ранеею
2. При созданиии 100 000 обьектов Сборщик мусора запускается автоматически во время выполнения программы.
Удаление обьектов происходит "пачками", частично освобождая память.
Затем создаются объекты и снова Сборщик мусораудаляет часть.
3. В Jconsole на графике Heap Memory Usage можно увидеть как увеличивается потребление памяти во время запска программы. 
4. В Jconsole на вкладке Memory можно увидеть "зубастый" график,
что говорит о заполении кучи и следом запуске Сборщика мусора
5. Так как метод finalize запускается один раз для обьекта, то возможно "воскресить" объект.
Объект будет помечен как завершенный поэтому когда он снова станет подходящим для сорки мусоар, 
метод finalize не будет вызван. 

LOG для пункта 5:
```
"C:\Program Files\Java\jdk-13.0.1\bin\java.exe" -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.1.2\lib\idea_rt.jar=2352:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.1.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.1.2\lib\idea_rt.jar;C:\Users\andre\.m2\repository\org\junit\platform\junit-platform-launcher\1.4.0\junit-platform-launcher-1.4.0.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.1.2\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.1.2\plugins\junit\lib\junit-rt.jar;D:\dev\brotrainee\traineeship\module1\target\test-classes;D:\dev\brotrainee\traineeship\module1\target\classes;C:\Users\andre\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.4.0\junit-jupiter-api-5.4.0.jar;C:\Users\andre\.m2\repository\org\apiguardian\apiguardian-api\1.0.0\apiguardian-api-1.0.0.jar;C:\Users\andre\.m2\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;C:\Users\andre\.m2\repository\org\junit\platform\junit-platform-commons\1.4.0\junit-platform-commons-1.4.0.jar;C:\Users\andre\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.4.0\junit-jupiter-engine-5.4.0.jar;C:\Users\andre\.m2\repository\org\junit\platform\junit-platform-engine\1.4.0\junit-platform-engine-1.4.0.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 net.broscorp.gc.GarbageCollectorTest,testCGAliveAfterFinalize

This is finalize method
MyObject still alive!

Process finished with exit code 0
```
6. Пара объектов с циклической ссылкой имеет право на сборку мусора.
 Это связано с тем, как сборщик мусора в Java обрабатывает циклические ссылки. 
 Он считает объекты живыми не тогда, когда они имеют какую-либо ссылку на них, 
 а когда они достижимы путем навигации по графу объектов.
 Если пара объектов с круговой ссылкой недоступна из любого корня, 
 она считается пригодной для сборки мусора.
 
 LOG для пункта 6:
 ```
 finalize was invoked for Developer=2
 finalize was invoked for Developer=1
```

LOG для пункта 2:
```
Developer=993367 was created
Developer=993368 was created
Developer=993369 was created
Developer=993370 was created
Developer=993371 was created
Developer=993372 was created
Developer=993373 was created
Developer=993374 was created
Developer=993375 was created
Developer=993376 was created
finalize was invoked for Developer=772061
finalize was invoked for Developer=772063
finalize was invoked for Developer=834652
finalize was invoked for Developer=834651
finalize was invoked for Developer=834650
Developer=993377 was created
Developer=993378 was created
Developer=993379 was created
Developer=993380 was created
Developer=993381 was created
Developer=993382 was created
Developer=993383 was created
Developer=993384 was created
Developer=993385 was created
Developer=993386 was created
Developer=993387 was created
Developer=993388 was created
Developer=993389 was created
finalize was invoked for Developer=772094
finalize was invoked for Developer=772103
finalize was invoked for Developer=772105
finalize was invoked for Developer=834609
finalize was invoked for Developer=834608
finalize was invoked for Developer=834607
finalize was invoked for Developer=834606
finalize was invoked for Developer=834605
finalize was invoked for Developer=834604
finalize was invoked for Developer=834603
```