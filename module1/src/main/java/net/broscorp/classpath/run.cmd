javac -d compiler  *.java

jar -cmf manifest.mf MyApp.jar -C compiler .

java -jar MyApp.jar