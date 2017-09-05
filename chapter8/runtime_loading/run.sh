$JAVA_HOME/bin/javac --module-path mods       \
      -d out         \
      --module-source-path src \
      -m runtime.loading.example
$JAVA_HOME/bin/java --module-path mods:out --add-modules hsqldb -m runtime.loading.example/demo.Main
