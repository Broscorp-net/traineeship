javac -d . .\*.java

jar -cmf manifest.mf classpath.jar *.class
java -jar classpath.jar

