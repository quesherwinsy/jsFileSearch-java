@echo off
setlocal enabledelayedexpansion
:: This program ask for user input of Directory location,
:: then it looks for the file format with (.js) in the given directory.

:: Ask user input for file directory.
SET /P userDir=Please enter file directory:
SET /A returnVal = 0
echo Your selected directory is: %userDir%

:: Checks if the file directory exist or not.
:: If file directory exist, look for file format with (.js) and writes them in a text file (directoryList.txt).
:: If file directory does not exist, end of program.
IF EXIST %userDir% (
	echo File directory %userDir% Exist.
	for /R %userDir% %%F in (*.js) do (
		echo "%%F"
		echo %%F >> directoryList.txt
	)
) ELSE (
	echo File directory %userDir% Does not exist.)
PAUSE
