javac Main.java

java Main

printf "\n\n|||||||||||||||\n\n" >> decompile.txt

javap -c -p  Main  >&1 | tee -a  decompile.txt