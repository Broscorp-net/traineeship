#!/bin/sh
echo "Main-Class: net.broscorp.classpath.ReadFromConsole" > manifest.mf
cd ../../..
javac  net\\broscorp\\classpath\\*.java
jar cfm net\\broscorp\\classpath\\app.jar net\\broscorp\\classpath\\manifest.mf net\\broscorp\\classpath\\*.class
java -jar net\\broscorp\\classpath\\app.jar