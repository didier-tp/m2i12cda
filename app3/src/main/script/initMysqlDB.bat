cd /d %~dp0
call set_env.bat
"%MYSQL_HOME%\bin\mysql" -u root -p < devise-mysql.sql
pause