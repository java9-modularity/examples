rm -rf out
$JAVA_HOME/bin/javac -d out src/modulename/Main.java

$JAVA_HOME/bin/jar -cfem out/modulename.jar modulename.Main src/META-INF/MANIFEST.MF -C out/ .

# start modulename.jar as automatic module
$JAVA_HOME/bin/java -ea --module-path out/modulename.jar -m com.javamodularity.modulename
