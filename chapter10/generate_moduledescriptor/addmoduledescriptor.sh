./build.sh
cd out
mkdir mylibrary-classes
cd mylibrary-classes
jar -xf ../mylibrary.jar
cd ..
javac -d mylibrary-classes mylibrary/module-info.java
jar -uf mylibrary.jar -C mylibrary-classes module-info.class
cd ..
