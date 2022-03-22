@echo off

SET HM=%HOMEPATH%

SET CP=%HM%\WORK\MyJava\J2EE_JPA\CH04_JPA\target\classes

rem SET CP=%HM%\WORK\MyJava\J2EE_JPA\CH04_JPA\target\ch04_jpa-1.0.jar

rem SET CP=%CP%;%HM%\WORK\MyJava\J2EE_JPA\CH04_JPA\target\classes\META-INF


rem find org.eclipse.persistence.jpa.PersistenceProvider....
rem ClassNotFoundException!
rem find org.eclipse.persistence.config.TargetServer....
rem ClassNotFoundException!
rem find class ru.unclediga.book.jpa.ch04.Book....
rem finded class ru.unclediga.book.jpa.ch04.Book
rem ...
rem javax.persistence.PersistenceException: No Persistence provider for EntityManager named chapter04PU
rem        at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:85)
rem        at javax.persistence.Persistence.createEntityManagerFactory(Persistence.java:54)
rem        at ru.unclediga.book.jpa.ch04.Tester.saveBook(Tester.java:100)
rem        at ru.unclediga.book.jpa.ch04.Main.main(Main.java:11)


rem CHOISE 
rem V1
SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\eclipselink\2.6.2\eclipselink-2.6.2.jar;


rem V2
rem SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\org.eclipse.persistence.jpa\2.6.2\org.eclipse.persistence.jpa-2.6.2.jar;
rem SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\org.eclipse.persistence.asm\2.6.2\org.eclipse.persistence.asm-2.6.2.jar;
rem SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\org.eclipse.persistence.antlr\2.6.2\org.eclipse.persistence.antlr-2.6.2.jar;
rem SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\org.eclipse.persistence.jpa.jpql\2.6.2\org.eclipse.persistence.jpa.jpql-2.6.2.jar;
rem SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\org.eclipse.persistence.core\2.6.2\org.eclipse.persistence.core-2.6.2.jar;



rem Exception in thread "main" java.lang.NoClassDefFoundError: javax/persistence/spi/PersistenceProvider
SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\javax.persistence\2.1.1\javax.persistence-2.1.1.jar;

SET CP=%CP%;%HM%\.m2\repository\org\eclipse\persistence\commonj.sdo\2.1.1\commonj.sdo-2.1.1.jar;
SET CP=%CP%;%HM%\.m2\repository\javax\validation\validation-api\1.1.0.Final\validation-api-1.1.0.Final.jar;
SET CP=%CP%;%HM%\.m2\repository\org\glassfish\javax.json\1.0.4\javax.json-1.0.4.jar;

SET CP=%CP%;%HM%\.m2\repository\org\hibernate\hibernate-validator\5.2.0.Final\hibernate-validator-5.2.0.Final.jar;
SET CP=%CP%;%HM%\.m2\repository\org\jboss\logging\jboss-logging\3.2.1.Final\jboss-logging-3.2.1.Final.jar;
SET CP=%CP%;%HM%\.m2\repository\com\fasterxml\classmate\1.1.0\classmate-1.1.0.jar;
SET CP=%CP%;%HM%\.m2\repository\org\glassfish\javax.el\3.0.1-b03\javax.el-3.0.1-b03.jar;
SET CP=%CP%;%HM%\.m2\repository\org\hsqldb\hsqldb\2.4.1\hsqldb-2.4.1.jar;
SET CP=%CP%;%HM%\.m2\repository\org\apache\derby\derby\10.10.1.1\derby-10.10.1.1.jar;
SET CP=%CP%;%HM%\.m2\repository\org\apache\derby\derbyclient\10.10.1.1\derbyclient-10.10.1.1.jar; 

%HM%\Java\jdk1.8\bin\java -cp %CP% ru.unclediga.book.jpa.ch04.Main
 
