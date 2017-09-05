rm -rf out*/
$JAVA_HOME/bin/javac --module-source-path src -d out -m easytext.syllablecounter
$JAVA_HOME/bin/javac --module-path lib:out --module-source-path src-test -d out-test -m easytext.syllablecounter.junit
$JAVA_HOME/bin/java --module-path lib:out:out-test \
     --add-modules easytext.syllablecounter.junit \
     -m junit/org.junit.runner.JUnitCore javamodularity.easytext.test.JUnitTestSyllableCounter
