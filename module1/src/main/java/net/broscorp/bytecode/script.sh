#!/bin/bash

echo "Compiling"
javac ExampleClass.java 
echo "Running"
java ExampleClass

printf "\n================= ++++++++ =================\n\n" >> disassemb.txt

echo "Disassembling"
javap -c -p  ExampleClass  >&1 | tee -a  disassemb.txt 
exit 0

