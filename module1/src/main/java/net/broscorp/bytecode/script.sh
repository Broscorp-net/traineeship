#!/bin/bash
javac Bytecode.java
cd ../../..
java net.broscorp.bytecode.Bytecode
javap -c -p net.broscorp.bytecode.Bytecode > net\\broscorp\\bytecode\\disassembled.txt
