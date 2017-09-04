rm -rf out*/
javac --module-source-path src -d out -m easytext.syllablecounter
javac --module-path lib:out --module-source-path src-test -d out-test -m easytext.syllablecounter.junit
java --module-path lib:out:out-test \
     --add-modules easytext.syllablecounter.junit \
     -m junit/org.junit.runner.JUnitCore javamodularity.easytext.test.JUnitTestSyllableCounter
