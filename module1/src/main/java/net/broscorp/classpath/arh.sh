#!/bin/bash

javac *.java

cd ../../..

jar cvmf net/broscorp/classpath/MANIFEST.MF net/broscorp/classpath/classpath.jar net/broscorp/classpath/*.class

java -jar net/broscorp/classpath/classpath.jar
