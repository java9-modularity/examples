./build.sh
cd out
mkdir mylibrary-classes
cd mylibrary-classes
$JAVA_HOME/bin/jar -xf ../mylibrary.jar
cd ..
$JAVA_HOME/bin/javac -d mylibrary-classes mylibrary/module-info.java
$JAVA_HOME/bin/jar -uf mylibrary.jar -C mylibrary-classes module-info.class
cd ..
