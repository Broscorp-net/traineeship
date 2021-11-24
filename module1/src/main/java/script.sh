#!/bin/bash
javac net\\broscorp\\bytecode\\Bytecode.java
java net.broscorp.bytecode.Bytecode
javap -c -p net.broscorp.bytecode.Bytecode > net\\broscorp\\bytecode\\disassembled.txt
