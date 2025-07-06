@echo off
REM Windows Gradle wrapper launch script
set DIR=%~dp0gradle\wrapper
java -jar "%DIR%\gradle-wrapper.jar" %*
