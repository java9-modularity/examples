CP=lib/jackson-annotations-2.8.8.jar:
CP+=lib/jackson-core-2.8.8.jar

$JAVA_HOME/bin/javac -cp $CP --module-path mods -d out --module-source-path src -m books

$JAVA_HOME/bin/java -cp $CP --module-path mods:out -m books/demo.Main
