javac --release 8 MainAndReader.java ConsoleWriter.java
echo Main-Class: net.broscorp.classpath.MainAndReader>classpath.mf
echo class-path: ..\..\..\>>classpath.mf
jar cfmv launcher.jar classpath.mf *.class
java -jar launcher.jar

