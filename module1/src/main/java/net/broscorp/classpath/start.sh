#!/bin/bash
javac -d bin *.java
jar -cmf manifest.mf classpath.jar -C bin .
java -jar classpath.jar
