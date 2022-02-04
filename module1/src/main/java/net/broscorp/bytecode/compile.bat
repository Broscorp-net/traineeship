javac -d compiler  Hello.java

java -classpath ./compiler net/broscorp/bytecode/Hello

javap -c -v -classpath ./compiler net/broscorp/bytecode/Hello

javap -s -classpath ./compiler net/broscorp/bytecode/Hello
