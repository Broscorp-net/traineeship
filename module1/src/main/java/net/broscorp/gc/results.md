1) При создании большого кол-ва объектов они удаляются в относительно произвольном порядке:

Ниже аутпут теста void manyObjectsTest():

_C:\Users\User\.jdks\openjdk-17.0.1\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar=49708:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\User\.m2\repository\org\junit\platform\junit-platform-launcher\1.4.0\junit-platform-launcher-1.4.0.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\plugins\junit\lib\junit-rt.jar;C:\Users\User\IdeaProjects\traineeship\module1\target\test-classes;C:\Users\User\IdeaProjects\traineeship\module1\target\classes;C:\Users\User\.m2\repository\org\projectlombok\lombok\1.18.22\lombok-1.18.22.jar;C:\Users\User\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.4.0\junit-jupiter-api-5.4.0.jar;C:\Users\User\.m2\repository\org\apiguardian\apiguardian-api\1.0.0\apiguardian-api-1.0.0.jar;C:\Users\User\.m2\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;C:\Users\User\.m2\repository\org\junit\platform\junit-platform-commons\1.4.0\junit-platform-commons-1.4.0.jar;C:\Users\User\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.4.0\junit-jupiter-engine-5.4.0.jar;C:\Users\User\.m2\repository\org\junit\platform\junit-platform-engine\1.4.0\junit-platform-engine-1.4.0.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 net.broscorp.gc.GcTest,manyObjectsTest
CountedObj 32831 is being finalized.
CountedObj 29587 is being finalized.
CountedObj 31675 is being finalized.
CountedObj 33579 is being finalized.
CountedObj 35220 is being finalized.
CountedObj 29109 is being finalized.
CountedObj 29827 is being finalized.
CountedObj 30570 is being finalized.
CountedObj 31261 is being finalized.
CountedObj 30112 is being finalized.
During the course of creating 10M objects, 2174045 were finalized._

из анализа jconsole видим резкие скачки памяти при вызове теста, который потом полностью очищается.
![](C:\Users\User\IdeaProjects\traineeship\module1\src\main\java\net\broscorp\gc\jconsole.png)

2) Тест makeReachableTest проверяет попадет ли объект в gc повторно если сделать его
достижимым в ходе действия finalize() - cогласно аутпуту ответ - нет (вызывается только один раз).

_C:\Users\User\.jdks\openjdk-17.0.1\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar=49701:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\User\.m2\repository\org\junit\platform\junit-platform-launcher\1.4.0\junit-platform-launcher-1.4.0.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\plugins\junit\lib\junit-rt.jar;C:\Users\User\IdeaProjects\traineeship\module1\target\test-classes;C:\Users\User\IdeaProjects\traineeship\module1\target\classes;C:\Users\User\.m2\repository\org\projectlombok\lombok\1.18.22\lombok-1.18.22.jar;C:\Users\User\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.4.0\junit-jupiter-api-5.4.0.jar;C:\Users\User\.m2\repository\org\apiguardian\apiguardian-api\1.0.0\apiguardian-api-1.0.0.jar;C:\Users\User\.m2\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;C:\Users\User\.m2\repository\org\junit\platform\junit-platform-commons\1.4.0\junit-platform-commons-1.4.0.jar;C:\Users\User\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.4.0\junit-jupiter-engine-5.4.0.jar;C:\Users\User\.m2\repository\org\junit\platform\junit-platform-engine\1.4.0\junit-platform-engine-1.4.0.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 net.broscorp.gc.GcTest,makeReachableTest
Reachable CountedObj 0 is being finalized._

3) Тест сrossReferenceTest проверяет будет ли очищен объект на который ссылается объект, который
сделался недостижимымм - согласно аутпуту ответ - да (для обоих объектов срабатывает finalize.)

C:\Users\User\.jdks\openjdk-17.0.1\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar=49723:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\User\.m2\repository\org\junit\platform\junit-platform-launcher\1.4.0\junit-platform-launcher-1.4.0.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3\plugins\junit\lib\junit-rt.jar;C:\Users\User\IdeaProjects\traineeship\module1\target\test-classes;C:\Users\User\IdeaProjects\traineeship\module1\target\classes;C:\Users\User\.m2\repository\org\projectlombok\lombok\1.18.22\lombok-1.18.22.jar;C:\Users\User\.m2\repository\org\junit\jupiter\junit-jupiter-api\5.4.0\junit-jupiter-api-5.4.0.jar;C:\Users\User\.m2\repository\org\apiguardian\apiguardian-api\1.0.0\apiguardian-api-1.0.0.jar;C:\Users\User\.m2\repository\org\opentest4j\opentest4j\1.1.1\opentest4j-1.1.1.jar;C:\Users\User\.m2\repository\org\junit\platform\junit-platform-commons\1.4.0\junit-platform-commons-1.4.0.jar;C:\Users\User\.m2\repository\org\junit\jupiter\junit-jupiter-engine\5.4.0\junit-jupiter-engine-5.4.0.jar;C:\Users\User\.m2\repository\org\junit\platform\junit-platform-engine\1.4.0\junit-platform-engine-1.4.0.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 net.broscorp.gc.GcTest,crossReferenceTest
CountedObj 0 is being finalized.
CountedObj 1 is being finalized.

