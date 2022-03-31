#!/bin/bash
javac Bytecode.java
cd ../../../
java net.broscorp.bytecode.Bytecode
javap -c net.broscorp.bytecode.Bytecode > net/broscorp/bytecode/bytecode1.txt