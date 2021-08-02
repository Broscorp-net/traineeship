@ECHO off
javac *.java
cd ../../../
jar cfe net\broscorp\classpath\IOtest.jar net.broscorp.classpath.Main net\broscorp\classpath\*.class
java -jar net\broscorp\classpath\IOtest.jar
pause