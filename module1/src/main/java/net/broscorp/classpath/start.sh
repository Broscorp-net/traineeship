javac -cp ./src/main/java /Users/Xiaomi/IdeaProjects/traineeship/module1/src/main/java/net/broscorp/classpath/*.java -d ./bin/
jar cvfm main.jar /Users/Xiaomi/IdeaProjects/traineeship/module1/src/main/resources/info.MF -C ./bin/ .
java -jar ./main.jar