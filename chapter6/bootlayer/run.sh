mkdir -p mods

$JAVA_HOME/bin/javac --module-source-path src -d mods -m application

$JAVA_HOME/bin/java --module-path mods -m application/javamodularity.application.Main
