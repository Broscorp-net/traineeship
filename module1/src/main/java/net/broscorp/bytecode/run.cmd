@echo off
 set Name = SimpleThing
 javac   -d  /classes SimpleThing.java
 pause
 echo Successfully Compiled
 java -cp .;/classes net.broscorp.bytecode.SimpleThing
 echo Successfully Ran
 pause
 javap -c -s -verbose -cp .;/classes net.broscorp.bytecode.SimpleThing >simplething_bytecode2.txt
 pause