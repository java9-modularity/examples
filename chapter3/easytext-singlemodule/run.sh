mkdir -p out

$JAVA_HOME/bin/javac -d out --module-source-path src -m easytext
$JAVA_HOME/bin/java --module-path out -m easytext/javamodularity.easytext.Main
