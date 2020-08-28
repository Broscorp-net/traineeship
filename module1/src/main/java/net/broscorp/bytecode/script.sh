gnome-terminal --execute bash -c 'cd ../../../../ &&
javac java/net/broscorp/bytecode/*.java &&
java -cp java net.broscorp.bytecode.PostfixIncrement &&
java -cp java net.broscorp.bytecode.PrefixIncrement;read'