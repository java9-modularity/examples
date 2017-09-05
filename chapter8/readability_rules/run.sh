CP=lib/jackson-annotations-2.8.8.jar:
CP+=lib/jackson-core-2.8.8.jar

$JAVA_HOME/bin/javac --module-path mods       \
      -cp $CP \
      -d out         \
      --module-source-path src \
      -m books
