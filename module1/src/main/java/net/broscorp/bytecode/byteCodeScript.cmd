javac -d bin  src\main\java\net\broscorp\bytecode\ByteCode.java
java -cp "bin" net.broscorp.bytecode.ByteCode
javap -c bin\net\broscorp\bytecode\ByteCode.class
