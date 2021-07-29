ECHO on
javac WorkWithByteCode.java
javap -c WorkWithByteCode.class > result_disassemble.txt
java -cp ..\..\..\ net.broscorp.bytecode.WorkWithByteCode
pause