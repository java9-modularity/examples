rm -rf out
javac -d out src/modulename/Main.java

jar -cfem out/modulename.jar modulename.Main src/META-INF/MANIFEST.MF -C out/ .

# start modulename.jar as automatic module
java -ea --module-path out/modulename.jar -m com.javamodularity.modulename
