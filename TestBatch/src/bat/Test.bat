echo off

cd C:\USER_HOME\Simula\Simula-2.0

java -jar simula.jar -help
pause

echo  
echo ****************************
echo *** Compile Simula files ***
echo ****************************
rem set simOptions=-verbose -noexec
set simOptions=-noexec
java -jar simula.jar %simOptions% samples\HelloWorld.sim
java -jar simula.jar %simOptions% samples\Sudoku.sim
java -jar simula.jar %simOptions% samples\LiftSimulation.sim

pause

cd C:\USER_HOME\samples
rem set execOptions=-verbose -useConsole
set execOptions=-verbose

echo  
echo ***************************************************
echo *** Execute Suduko.jar with options %execOptions%
echo ***************************************************
java -jar C:\USER_HOME\Simula\Simula-2.0\samples\bin\Sudoku.jar %execOptions%
pause

echo  
echo ***************************************************
echo *** Execute Suduko.jar with options %execOptions%
echo ***************************************************
java -jar C:\USER_HOME\Simula\Simula-2.0\samples\bin\LiftSimulation.jar %execOptions%
pause
