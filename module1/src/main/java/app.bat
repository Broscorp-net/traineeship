javac net\broscorp\b_bytecode\MainFirst.java
javac net\broscorp\b_bytecode\MainSecond.java
java net.broscorp.b_bytecode.MainFirst
java net.broscorp.b_bytecode.MainSecond
java -jar lib\jd-cli.jar -n -od net\broscorp\b_bytecode\decompiler net\broscorp\b_bytecode\MainFirst.class
java -jar lib\jd-cli.jar -n -od net\broscorp\b_bytecode\decompiler net\broscorp\b_bytecode\MainSecond.class
