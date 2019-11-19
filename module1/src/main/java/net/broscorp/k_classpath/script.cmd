javac FirstClass.java SecondClass.java
jar -cvfe MyJar.jar FirstClass FirstClass.class SecondClass.class
java -cp MyJar.jar FirstClass SecondClass
java -jar MyJar.jar
cmd /k