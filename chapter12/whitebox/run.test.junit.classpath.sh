rm -rf out*/
$JAVA_HOME/bin/javac --module-source-path src -d out -m easytext.syllablecounter
$JAVA_HOME/bin/javac -cp lib/junit-4.12.jar:out/easytext.syllablecounter -d out-test \
      src-test/javamodularity/easytext/syllablecounter/vowel/JUnitTestVowelHelper.java

$JAVA_HOME/bin/java -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:out/easytext.syllablecounter:out-test \
     org.junit.runner.JUnitCore javamodularity.easytext.syllablecounter.vowel.JUnitTestVowelHelper
