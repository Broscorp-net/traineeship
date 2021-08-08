javac *.java
jar -cfm classpath.jar manifest.mf *.class
java -jar classpath.jar
