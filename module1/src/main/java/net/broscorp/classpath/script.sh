gnome-terminal -x bash -c 'javac -d . *.java &&
jar -cmf manifest.mf readFromConsole.jar net/broscorp/classpath &&
java -jar readFromConsole.jar;read'