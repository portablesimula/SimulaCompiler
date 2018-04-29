echo Two sample calls on Simula-Compiler
echo SIMULA_HOME=%SIMULA_HOME%
echo JAVA_HOME=%JAVA_HOME%
pause
dir
pause
cd ./bin
dir
pause
jar cmf ..\MANIFEST.MF %SIMULA_HOME%\simula.jar .
pause
jar -tvf %SIMULA_HOME%\simula.jar
pause
java -jar %SIMULA_HOME%\simula.jar
pause
echo *** Copy Current Runtime System
rem Robocopy C:\Directory_A C:\Directory_B /E
pause
Robocopy .\Simula\runtime %SIMULA_HOME%\rts\Simula\runtime /E
echo *** Copy Current Compiler Also -- TEMP
pause
Robocopy .\Simula\compiler %SIMULA_HOME%\rts\Simula\compiler /E
pause
