###ExampleBytecode
Firstly, we can see that compiler invokes default constructor of the class

Bytecode instructions such as aload_0, iconst_0, istore_1 describe variables
and their data types. Prefix "a" means that is reference to the object.
Prefix "i" describes an integer.

Also we can see that some instructions have operands like #1 or #2.
After running `javap -c -s -verbose net.broscorp.bytecode.BytecodeExample2`,
we get more details about operands.

###Example2Bytecode
I have just moved println method to incrementAndGet() method.
And I got less bytecode instructions, 29 instead of 41 in the previous example.