@echo off
REM Script para rodar o jogo Crash TH Foguete com JavaFX

set JAVA_FX_LIB=C:\javafx-sdk-21.0.7\lib
set CP=bin;lib\gson-2.10.1.jar

REM Executar com fallback para pipeline software
java --module-path "%JAVA_FX_LIB%" --add-modules javafx.controls,javafx.fxml -cp "%CP%" -Dprism.verbose=true -Dprism.order=sw web.TelaInicial

pause
