@echo off

cd ../../../
dir
javac ./net/broscorp/classpath/*.java
jar cfvm ConsoleInput.jar ./net/broscorp/classpath/manifest.mf ./net/broscorp/classpath/*.class
java -jar ConsoleInput.jar
