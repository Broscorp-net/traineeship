#!/usr/bin/env bash

cd ~/Desktop
javac MyReader.java MyWriter.java
jar cfm Console_Reader.jar manifest.txt MyReader.class MyWriter.class



# For script execution in Terminal You should write next command lines:


# 1)  chmod +x k_classPathScript.sh
# 2)  ./k_classPathScript.sh 