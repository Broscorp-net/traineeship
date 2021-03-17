@echo off
 set Name = SimpleThing
 javac   -d ../../../../../../target/classes  SimpleThing.java
 pause
 echo Successfully Compiled
 java -classpath ./../../../../../../target/classes net.broscorp.bytecode.SimpleThing
 echo Successfully Ran
 pause
 javap -classpath ./../../../../../../target/classes net.broscorp.bytecode.SimpleThing
 pause