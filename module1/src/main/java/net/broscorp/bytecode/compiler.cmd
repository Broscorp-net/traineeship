javac Main.java
javap -c Main.class > result%RANDOM%.txt
java -classpath ..\..\..\ net.broscorp.bytecode.Main
del Main.class
pause