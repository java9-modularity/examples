CP=lib/antlr-2.7.7.jar:
CP+=lib/cdi-api-1.1.jar:
CP+=lib/classmate-1.3.0.jar:
CP+=lib/commons-dbcp-1.4.jar:
CP+=lib/commons-logging-1.2.jar:
CP+=lib/commons-pool-1.5.4.jar:
CP+=lib/dom4j-1.6.1.jar:
CP+=lib/el-api-2.2.jar:
CP+=lib/geronimo-jta_1.1_spec-1.1.1.jar:
CP+=lib/hibernate-commons-annotations-5.0.1.Final.jar:
CP+=lib/hsqldb-2.3.4.jar:
CP+=lib/jandex-2.0.0.Final.jar:
CP+=lib/jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar:
CP+=lib/jboss-logging-3.3.0.Final.jar:
CP+=lib/jcl-over-slf4j-1.7.21.jar:
CP+=lib/jsr250-api-1.0.jar:
CP+=lib/log4j-api-2.6.2.jar:
CP+=lib/log4j-core-2.6.2.jar:
CP+=lib/slf4j-api-1.7.21.jar:
CP+=lib/slf4j-simple-1.7.21.jar:
CP+=lib/spring-aop-4.3.2.RELEASE.jar:
CP+=lib/spring-beans-4.3.2.RELEASE.jar:
CP+=lib/spring-core-4.3.2.RELEASE.jar:
CP+=lib/spring-expression-4.3.2.RELEASE.jar:
CP+=lib/spring-jdbc-4.3.2.RELEASE.jar:
CP+=lib/spring-orm-4.3.2.RELEASE.jar

$JAVA_HOME/bin/javac -cp $CP \
      --module-path mods \
      --add-modules java.naming \
      -d out         \
      --module-source-path src \
      -m bookapp

cp $(find src -name '*.xml') out/bookapp

$JAVA_HOME/bin/java -cp $CP \
     --module-path mods:out       \
     --add-modules java.xml.bind,java.sql \
     --add-opens java.base/java.lang=javassist \
     -m bookapp/main.Main
