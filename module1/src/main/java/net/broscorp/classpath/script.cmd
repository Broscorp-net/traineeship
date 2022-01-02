javac MyReader.java
javac MyWriter.java
jar cfm MyJar.jar *.class
rem jar cfm MyJar.jar Manifest.txt *.class
rem java -cp myjar.jar MyReader
java -cp myjar.jar net.broscorp.classpath.MyReader
java -cp myjar.jar net.broscorp.classpath.MyWriter