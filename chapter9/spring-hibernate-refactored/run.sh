CLASSPATH=lib/antlr-2.7.7.jar:lib/cdi-api-1.1.jar:lib/classmate-1.3.0.jar:lib/commons-dbcp-1.4.jar:lib/commons-logging-1.2.jar:lib/commons-pool-1.5.4.jar:lib/dom4j-1.6.1.jar:lib/el-api-2.2.jar:lib/geronimo-jta_1.1_spec-1.1.1.jar:lib/hibernate-commons-annotations-5.0.1.Final.jar:lib/hsqldb-2.3.4.jar:lib/jandex-2.0.0.Final.jar:lib/jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar:lib/jboss-logging-3.3.0.Final.jar:lib/jcl-over-slf4j-1.7.21.jar:lib/jsr250-api-1.0.jar:lib/log4j-api-2.6.2.jar:lib/log4j-core-2.6.2.jar:lib/slf4j-api-1.7.21.jar:lib/slf4j-simple-1.7.21.jar:lib/spring-aop-4.3.2.RELEASE.jar:lib/spring-beans-4.3.2.RELEASE.jar:lib/spring-core-4.3.2.RELEASE.jar:lib/spring-expression-4.3.2.RELEASE.jar:lib/spring-jdbc-4.3.2.RELEASE.jar:lib/spring-orm-4.3.2.RELEASE.jar

javac -cp $CLASSPATH \
      --module-path mods       \
      -d out         \
      --module-source-path src \
      -m books.api,books.impl,bookstore,main

cp $(find src -name '*.xml') out/main

java -cp $CLASSPATH     \
     --module-path mods:out \
     --add-modules java.xml.bind,java.sql,books.impl \
     --add-opens java.base/java.lang=javassist \
     -m main/main.Main
