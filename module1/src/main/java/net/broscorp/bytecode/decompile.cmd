@echo off
"C:\Program Files (x86)\jdk-16.0.1\bin\javac.exe" MyClass.java
"C:\Program Files (x86)\jdk-16.0.1\bin\java.exe" MyClass.java
"C:\Program Files (x86)\jdk-16.0.1\bin\javap.exe" -c MyClass > output2.txt
type output2.txt