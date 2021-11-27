cd net/broscorp/classpath
type nul > Manifest.mf
echo Main-Class: net.broscorp.classpath.Application > Manifest.mf
cd ../../..
javac net/broscorp/classpath/*.java
jar cfm net/broscorp/classpath/MyJar.jar net/broscorp/classpath/Manifest.mf net/broscorp/classpath/*.class
java -jar net/broscorp/classpath/MyJar.jar