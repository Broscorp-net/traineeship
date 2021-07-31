#!/bin/bash

echo "Compiling....."
javac *.java
echo Main-Class: MainClass > MANIFEST.MF
echo "Packing......."
jar cmf MANIFEST.MF mainjar.jar *.class
echo "Executing....."
java -jar mainjar.jar
