#!/bin/bash

javac TestApp.java

java -cp ../../../ net.broscorp.bytecode.TestApp

javap -c TestApp


#При изменении или добавлении новых переменных и методов это отображается в байт коде