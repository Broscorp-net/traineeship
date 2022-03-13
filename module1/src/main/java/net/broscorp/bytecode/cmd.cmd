@echo off

cd c:\Users\DLysak\IdeaProjects\traineeship\module1\src\main\java\
javac net/broscorp/bytecode/SimpleMeth.java
java net.broscorp.bytecode.SimpleMeth
javap -c net.broscorp.bytecode.SimpleMeth > ./net/broscorp/bytecode/bytecode2.txt
pause 1000