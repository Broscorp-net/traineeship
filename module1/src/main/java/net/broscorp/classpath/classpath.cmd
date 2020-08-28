javac -d . FirstClass.java SecondClass.java
jar -cmf manifest.mf classpath.jar net/broscorp/classpath/*
java -jar classpath.jar
pause