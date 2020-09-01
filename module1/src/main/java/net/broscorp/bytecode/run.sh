CUR_DIR=$(pwd)
CLASSPATH=${CUR_DIR%%/net/broscorp/bytecode} # remove package from current directory

javac Util.java
java -cp $CLASSPATH net.broscorp.bytecode.Util
javap -c -p Util.class > bytecode_v2.txt
