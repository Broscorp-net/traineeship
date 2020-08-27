cls

echo Compiling...
javac -d . *.java

echo Creating JAR...
jar cfve app.jar net/broscorp/classpath/ConsoleScanner net/broscorp/classpath/*.class

echo All done!