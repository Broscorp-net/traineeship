javac *.java
echo Main-Class: ReadFromConsole >manifest.txt
jar cvfm classpath.jar manifest.txt *.class
java -jar classpath.jar
