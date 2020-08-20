javac -cp ./src/main/java ./src/main/java/net/broscorp/classpath/*.java -d ./bin/
jar cvfm read.jar ./src/main/resources/META-INF/MANIFEST.MF -C ./bin/ .
java -jar ./read.jar