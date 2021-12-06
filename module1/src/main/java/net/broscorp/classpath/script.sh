javac -d class ConsoleValue.java ConsolePrintValue.java
java  -cp class net.broscorp.classpath.ConsoleValue
jar cfm printStuff.jar MANIFEST.MF -C class .
java -jar printStuff.jar
cmd /k