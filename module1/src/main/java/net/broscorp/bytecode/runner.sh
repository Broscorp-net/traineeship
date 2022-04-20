#!/bin/bash
javac Plain.java
java Plain
javap -c Plain > decompiled.txt