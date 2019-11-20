cd /d %~dp0
call set_env.bat
REM app3-1.0-SNAPSHOT-jar-with-dependencies.jar à fabriquer via mvn assembly:single
java -jar target/app3-1.0-SNAPSHOT-jar-with-dependencies.jar
REM ou bien si le fichier META-INF/Manifest.mf n'existe pas ...
REM java -classpath ./targetapp3-1.0-SNAPSHOT-jar-with-dependencies.jar com.mycompany.app3.App3