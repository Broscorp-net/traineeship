javac *.java
jar -cfm ClassPath.jar META-INF/MANIFEST.MF *.class
java -jar ClassPath.jar