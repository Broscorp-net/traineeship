#!/bin/bash

javac MyByteCode.java
javac MyByteCode1.java
javac MyByteCode2.java

cd ../../..

java net.broscorp.bytecode.MyByteCode
javap -c net.broscorp.bytecode.MyByteCode > net/broscorp/bytecode/MyByteCode.disassembled

java net.broscorp.bytecode.MyByteCode1
javap -c net.broscorp.bytecode.MyByteCode1 > net/broscorp/bytecode/MyByteCode1.disassembled

java net.broscorp.bytecode.MyByteCode2
javap -c net.broscorp.bytecode.MyByteCode2 > net/broscorp/bytecode/MyByteCode2.disassembled