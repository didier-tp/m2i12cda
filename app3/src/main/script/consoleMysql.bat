cd /d %~dp0
call set_env.bat
"%MYSQL_HOME%\bin\mysql" -u root -p
REM password may be root or ...
REM use myDeviseDb;
REM SELECT * from Devise;
pause