javac -d . .\*.java


echo main-class: ClassPathMain> manifest.mf
echo class-path: .>>manifest.mf


jar -cmf manifest.mf classpath.jar *.class
java -jar classpath.jar

