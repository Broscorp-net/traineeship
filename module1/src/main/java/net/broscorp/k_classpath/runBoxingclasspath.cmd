javac -d . *java
jar cfm classpath.jar manifest net/broscorp/k_classpath/*.class
pause
java -jar classpath.jar
pause