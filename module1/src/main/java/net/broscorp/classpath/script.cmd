cd net/broscorp/classpath
type nul > manifest.mf
echo Main-Class: net.broscorp.classpath.ReadConsole > manifest.mf
cd ../../..
javac net/broscorp/classpath/*.java
jar cfm net/broscorp/classpath/File.jar net/broscorp/classpath/manifest.mf net/broscorp/classpath/*.class
java -jar net/broscorp/classpath/File.jar