javac -d bin *.java
java -cp bin net.broscorp.classpath.ConsoleWriter
jar -cmf manifest.mf some-jar.jar -C bin .
java -jar some-jar.jar
