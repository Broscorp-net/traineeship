@echo off
set MainName=ReadConsole
set JarName=ReadWriteApp
javac  ./*.java
pause
echo Successfully Compiled
jar cfe %JarName%.jar  net.broscorp.classpath.%MainName%  ./../../../net/broscorp/classpath/*.class
java -jar %JarName%.jar

pause