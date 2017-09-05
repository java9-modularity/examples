rm -rf out*/
$JAVA_HOME/bin/javac --module-source-path src -d out -m easytext.syllablecounter
$JAVA_HOME/bin/javac --module-path out --module-source-path src-test -d out-test -m easytext.syllablecounter.test
$JAVA_HOME/bin/java -ea --module-path out:out-test \
     -m easytext.syllablecounter.test/javamodularity.easytext.test.TestSyllableCounter
