$JAVA_HOME/bin/javac -d out --add-modules java.xml.bind -sourcepath src $(find src -name '*.java')
$JAVA_HOME/bin/java -cp out --add-modules java.xml.bind example.JaxbExample