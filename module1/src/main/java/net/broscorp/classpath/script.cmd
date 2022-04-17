javac net/broscorp/classpath/*.java
jar cmf net/broscorp/classpath/MANIFEST.MF net/broscorp/classpath/Test.jar net/broscorp/classpath/*.class
java -jar net/broscorp/classpath/Test.jar