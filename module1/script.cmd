javac -d target/classes src/main/java/net/broscorp/bytecode/ByteCodeExample.java
cd target/classes
java net.broscorp.bytecode.ByteCodeExample
cd net/broscorp/bytecode
javap -c ByteCodeExample.class