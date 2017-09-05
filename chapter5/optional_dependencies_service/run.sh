mkdir -p mods

$JAVA_HOME/bin/javac --module-source-path src -d mods -m fastjsonlib,framework

$JAVA_HOME/bin/java --module-path mods -m framework/javamodularity.framework.Main