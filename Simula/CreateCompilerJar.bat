echo Two sample calls on Simula-Compiler
echo SIMULA_HOME=%SIMULA_HOME%
echo JAVA_HOME=%JAVA_HOME%
rem pause
dir
rem pause
cd ./bin
dir
rem pause

rem jar cmf ..\MANIFEST.MF %SIMULA_HOME%\simula.jar .
jar cmf ..\MANIFEST.MF %SIMULA_HOME%\simula.jar ./simula/compiler ./org/apache/bcel

rem pause
jar -tvf %SIMULA_HOME%\simula.jar
rem pause
java -jar %SIMULA_HOME%\simula.jar
rem pause
echo *** Copy Current Runtime System
rem Robocopy C:\Directory_A C:\Directory_B /E
rem pause
Robocopy .\simula\runtime %SIMULA_HOME%\rts\simula\runtime /E
echo *** Copy Current Compiler Also -- TEMP
rem pause
Robocopy .\simula\compiler %SIMULA_HOME%\rts\simula\compiler /E
rem pause
