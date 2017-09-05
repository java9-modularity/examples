mkdir -p mods

$JAVA_HOME/bin/javac --module-source-path src -d mods -m easytext.client,easytext.domain.api,easytext.repository.api
