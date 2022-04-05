#!/bin/zsh

javac -d Read.java Write.java
echo Main-Class: net.broscorp.classpath.Read > manifest.mf
jar -cmf manifest.mf ClassPath.jar ./net/broscorp/classpath/Read.class ./net/broscorp/classpath/Write.class
java -jar Classpath.jar