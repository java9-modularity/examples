rm -rf out
$JAVA_HOME/bin/javac -d out src/com/javamodularity/mylibrary/internal/Util.java src/com/javamodularity/mylibrary/MyLibrary.java

$JAVA_HOME/bin/jar -cf out/mylibrary.jar -C out/ .

$JAVA_HOME/bin/jdeps --generate-module-info ./out out/mylibrary.jar
cat out/mylibrary/module-info.java
