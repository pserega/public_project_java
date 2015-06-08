@ECHO OFF

d:\_development\apache-maven-3.2.1\bin\mvn clean compile assembly:single
echo assemble done
copy .\target\L1.4-1.0-jar-with-dependencies.jar .\
echo copy done
pause