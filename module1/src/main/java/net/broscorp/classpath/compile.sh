#!/bin/bash
javac -d . *.java
echo Main-Class: net.broscorp.classpath.FirstClass >manifest.mf
jar -cmf manifest.mf ClassPath.jar ./net/broscorp/classpath/*.class
java -jar ClassPath.jar
