echo Two sample calls on Simula-Compiler
echo %SIMULA_HOME%
pause
dir
java -jar .\jar\simula.jar
pause
java -cp %SIMULA_HOME%\simula.jar -jar %SIMULA_HOME%\simula.jar .\src\testing\sim\HelloWord.sim
pause
java -cp %SIMULA_HOME%\simula.jar -jar .\src\testing\sim\HelloWord.jar
pause