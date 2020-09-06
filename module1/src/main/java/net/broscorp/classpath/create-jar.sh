javac -d ./bin *.java
jar cvfm read-write.jar manifest.mf -C ./bin .
java -jar read-write.jar
