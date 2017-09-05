rm -rf out*/
$JAVA_HOME/bin/javac --module-source-path src -d out -m easytext.syllablecounter
$JAVA_HOME/bin/javac --patch-module easytext.syllablecounter=src-test \
      --module-path lib:out \
      --add-modules junit \
      --add-reads easytext.syllablecounter=junit \
      -d out-test src-test/javamodularity/easytext/syllablecounter/vowel/JUnitTestVowelHelper.java
$JAVA_HOME/bin/java --patch-module easytext.syllablecounter=out-test \
     --add-reads easytext.syllablecounter=junit \
     --add-opens easytext.syllablecounter/javamodularity.easytext.syllablecounter.vowel=junit \
     --module-path lib:out \
     --add-modules easytext.syllablecounter \
     -m junit/org.junit.runner.JUnitCore javamodularity.easytext.syllablecounter.vowel.JUnitTestVowelHelper
