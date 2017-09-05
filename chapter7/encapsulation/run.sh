mkdir -p mods

$JAVA_HOME/bin/javac -d out -sourcepath src $(find src -name '*.java')
