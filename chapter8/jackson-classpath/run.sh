CP=lib/jackson-annotations-2.8.8.jar:
CP+=lib/jackson-core-2.8.8.jar:
CP+=lib/jackson-databind-2.8.8.jar

javac -cp $CP -d out -sourcepath src $(find src -name '*.java')

java -cp $CP:out demo.Main
