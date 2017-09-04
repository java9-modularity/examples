javac --module-source-path src -d out $(find . -name '*.java')
java --module-path out -m application/javamodularity.application.Main
