rm -rf out
javac --release 7 -d out/7 src/mrlib/Main.java src/mrlib/Helper.java
javac --release 9 -d out/9 src/META-INF/versions/9/mrlib/Helper.java

jar -cfem out/mrlib.jar mrlib.Main src/META-INF/MANIFEST.MF -C out/7 .
jar -uf out/mrlib.jar --release 9 -C out/9 .
java -jar out/mrlib.jar
