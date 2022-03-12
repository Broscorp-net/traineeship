#!/bin/bash
javac ByteCode.java
cd ../../..
java net.broscorp.bytecode.ByteCode
javap -c net.broscorp.bytecode.ByteCode > net/broscorp/bytecode/ByteCode.bytecode
