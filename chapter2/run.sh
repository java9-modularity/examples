mkdir -p out

$JAVA_HOME/bin/javac -d out -sourcepath src $(find src -name '*.java')
$JAVA_HOME/bin/java -cp out NotInModule
