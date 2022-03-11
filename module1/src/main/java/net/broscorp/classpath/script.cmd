javac *.java
jar cfm javaapp.jar manifest.mf *.class
java -jar javaapp.jar
timeout /t 60