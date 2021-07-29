javac *.java

echo Main-Class: Craps >manifest.txt

jar cvfm Clathpass.jar manifest.txt *.class

java -jar Craps.jar