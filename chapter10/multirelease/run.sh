rm -rf out
$JAVA_HOME/bin/javac --release 7 -d out/7 src/mrlib/Main.java src/mrlib/Helper.java
$JAVA_HOME/bin/javac --release 9 -d out/9 src/META-INF/versions/9/mrlib/Helper.java

$JAVA_HOME/bin/jar -cfem out/mrlib.jar mrlib.Main src/META-INF/MANIFEST.MF -C out/7 .
$JAVA_HOME/bin/jar -uf out/mrlib.jar --release 9 -C out/9 .
$JAVA_HOME/bin/java -jar out/mrlib.jar
