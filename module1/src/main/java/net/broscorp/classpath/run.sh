#!/bin/bash

javac *.java
cd ../../../
jar cfe net/broscorp/classpath/app.jar net.broscorp.classpath.Main net/broscorp/classpath/*.class
java -jar net/broscorp/classpath/app.jar