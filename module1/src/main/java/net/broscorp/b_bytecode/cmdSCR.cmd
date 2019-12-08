javac Bitterest.java
javac Bitterest2.java
cd D:\IdeaProjects\Git\traineeship\module1\src\main\java\
java -cp . net.broscorp.b_bytecode.Bitterest
java -cp . net.broscorp.b_bytecode.Bitterest2
cd D:\IdeaProjects\Git\traineeship\module1\src\main\java\net\broscorp\b_bytecode
javap -v Bitterest.class> log.txt
javap -v Bitterest2.class> log1.txt
@pause
