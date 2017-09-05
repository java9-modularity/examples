javac --module-source-path src -d out -m ormframework,application
java --module-path out -m application/javamodularity.application.Main
