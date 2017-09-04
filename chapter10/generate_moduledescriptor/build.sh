rm -rf out
javac -d out src/com/javamodularity/mylibrary/internal/Util.java src/com/javamodularity/mylibrary/MyLibrary.java

jar -cf out/mylibrary.jar -C out/ .

jdeps --generate-module-info ./out out/mylibrary.jar
cat out/mylibrary/module-info.java
