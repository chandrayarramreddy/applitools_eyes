@echo off
echo %cd%
set CLASSPATH=.;C:\Users\miracle\Downloads\eyes-selenium-java_3_2_2\*
set APPLITOOLS_API_KEY=%key%
echo Compiling File %JavaCompileFile%
javac %JavaCompileFile%
echo Running File %JavaRunFile%
java %JavaRunFile%