echo Two sample calls on Simula-Compiler
echo %SIMULA_HOME%
echo %JAVA_HOME%
pause
dir
rem jar -tvf .\jar\simula.jar
pause
cd ./bin
dir
pause
rem jar -cp %SIMULA_HOME%\simula.jar -jar .\jar\simula.jar .\src\testing\sim\HelloWord.sim

jar cmf ..\MANIFEST.MF %SIMULA_HOME%\simula.jar .
pause
jar -tvf %SIMULA_HOME%\simula.jar
pause
java -jar %SIMULA_HOME%\simula.jar
pause