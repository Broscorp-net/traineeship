cd C:\Users\QM\test
javac net\broscorp\classpath\ConsoleReader.java
jar cvf Myjar.jar net\broscorp\classpath\ConsoleReader.class

::проверяем все ли работает
java -cp ".;Myjar.jar" net.broscorp.classpath.ConsoleReader
@pause