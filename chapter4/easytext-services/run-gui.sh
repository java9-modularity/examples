mkdir -p mods

$JAVA_HOME/bin/javac --module-source-path src -d mods -m easytext.analysis.api,easytext.analysis.coleman,easytext.analysis.kincaid,easytext.gui

$JAVA_HOME/bin/java --module-path mods -m easytext.gui/javamodularity.easytext.gui.Main ../exampletext.txt
