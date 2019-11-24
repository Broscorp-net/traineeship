javac -d . BytecodeTest.java
javac -d . BytecodeTest_2.java
java net/broscorp/b_bytecode/BytecodeTest
java net/broscorp/b_bytecode/BytecodeTest_2
pause
javap -c net.broscorp.b_bytecode.BytecodeTest
javap -c net.broscorp.b_bytecode.BytecodeTest_2
pause