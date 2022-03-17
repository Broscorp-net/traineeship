@echo off

cd ..
cd ..
cd ..
javac net/broscorp/classpath/ConsoleReader.java
javac net/broscorp/classpath/ConsoleWriter.java
echo Main-Class: net.broscorp.classpath.ConsoleReader> ./net/broscorp/classpath/manifest.txt
jar cvfm ./net/broscorp/classpath/MyJar.jar ./net/broscorp/classpath/manifest.txt ./net/broscorp/classpath/*.class
start ./net/broscorp/classpath/MyJar.jar