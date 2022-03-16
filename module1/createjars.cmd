javac -d target/classes src/main/java/net/broscorp/classpath/ConsoleReader.java
javac -d target/classes src/main/java/net/broscorp/classpath/ConsoleWriter.java
cd target/classes
jar cvfe ConsoleWriter.jar net.broscorp.classpath.ConsoleWriter net/broscorp/classpath/ConsoleWriter.class
jar cvfe ConsoleReader.jar net.broscorp.classpath.ConsoleReader net/broscorp/classpath/ConsoleReader.class

