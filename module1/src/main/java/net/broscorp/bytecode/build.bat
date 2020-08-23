cls

echo Compiling...
javac -d . *.java

echo Running...
java net.broscorp.bytecode.BytecodeExample2

echo Show bytecode. Disassembling...
javap -c -s -verbose net.broscorp.bytecode.BytecodeExample2

echo All done!