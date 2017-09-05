mkdir -p out
mkdir -p mods

$JAVA_HOME/bin/javac -d out/helloworld \
    src/helloworld/com/javamodularity/helloworld/HelloWorld.java \
    src/helloworld/module-info.java

$JAVA_HOME/bin/jar -cfe mods/helloworld.jar com.javamodularity.helloworld.HelloWorld -C out/helloworld .

$JAVA_HOME/bin/java --module-path out \
    --module helloworld/com.javamodularity.helloworld.HelloWorld
