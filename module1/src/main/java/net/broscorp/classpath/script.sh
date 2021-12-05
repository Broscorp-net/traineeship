javac -d class ConsoleValue.java ConsolePrintValue.java
java  -cp class net.broscorp.classpath.ConsoleValue
jar cmf MANIFEST.MF printStuff.jar class/
java -jar printStuff.jar
cmd /k