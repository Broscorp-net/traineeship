gnome-terminal --execute bash -c 'cd ../../../../ &&
javac java/net/broscorp/b_bytecode/*.java &&
java -cp java net.broscorp.b_bytecode.PostfixIncrement &&
java -cp java net.broscorp.b_bytecode.PrefixIncrement;read'