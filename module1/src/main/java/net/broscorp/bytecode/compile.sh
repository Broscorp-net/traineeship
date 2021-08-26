#!/bin/bash

javac MyByteCode.java

cd ../../..

java net.broscorp.bytecode.MyByteCode

javap -p net.broscorp.bytecode.MyByteCode


