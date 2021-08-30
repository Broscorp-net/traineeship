#!/bin/bash
javac Hello.java

cd ../../..

java net.broscorp.bytecode.Hello
javap -c net.broscorp.bytecode.Hello > net/broscorp/bytecode/Hello.bytecode3