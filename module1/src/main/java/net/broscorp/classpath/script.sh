javac -d . *.java
echo Main-Class: net.broscorp.classpath.ReadFromConsole >manifest.mf
jar -cmf manifest.mf ReadWrite.jar ./net/broscorp/classpath/*.class
java -jar ReadWrite.jar
