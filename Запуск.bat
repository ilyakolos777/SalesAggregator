@echo off
chcp 65001 >nul
cls

echo ╔════════════════════════════════════════════════════════════╗
echo ║         SalesAggregator - Агрегатор данных о продажах      ║
echo ║                  Лабораторная работа №3                    ║
echo ╚════════════════════════════════════════════════════════════╝
echo.

echo [1/3] Проверка окружения...
echo.

java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ОШИБКА] Java не найдена!
    echo.
    echo Пожалуйста, установите Java JDK 11 или выше:
    echo https://www.oracle.com/java/technologies/downloads/
    echo.
    pause
    exit /b 1
)

echo [✓] Java установлена
echo.

echo [2/3] Сборка проекта...
echo.

call gradlew.bat clean build --quiet
if %errorlevel% neq 0 (
    echo [ОШИБКА] Не удалось собрать проект!
    echo.
    echo Проверьте наличие ошибок в коде или подключение к интернету.
    echo.
    pause
    exit /b 1
)

echo [✓] Проект успешно собран
echo.

echo [3/3] Запуск приложения...
echo.
echo ═══════════════════════════════════════════════════════════════
echo.

call gradlew.bat run --quiet --console=plain

echo.
echo ═══════════════════════════════════════════════════════════════
echo.
echo [✓] Выполнение завершено!
echo.
pause
