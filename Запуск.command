#!/bin/bash

# Изменяем директорию на место нахождения скрипта
cd "$(dirname "$0")"

clear

echo "╔════════════════════════════════════════════════════════════╗"
echo "║         SalesAggregator - Агрегатор данных о продажах      ║"
echo "║                  Лабораторная работа №3                    ║"
echo "╚════════════════════════════════════════════════════════════╝"
echo ""

echo "[1/3] Проверка окружения..."
echo ""

# Проверка Java
if ! command -v java &> /dev/null; then
    echo "[ОШИБКА] Java не найдена!"
    echo ""
    echo "Пожалуйста, установите Java JDK 11 или выше:"
    echo "https://www.oracle.com/java/technologies/downloads/"
    echo ""
    read -p "Нажмите Enter для выхода..."
    exit 1
fi

echo "[✓] Java установлена"
echo ""

# Делаем gradlew исполняемым (если ещё не сделано)
chmod +x gradlew 2>/dev/null

echo "[2/3] Сборка проекта..."
echo ""

./gradlew clean build --quiet
if [ $? -ne 0 ]; then
    echo "[ОШИБКА] Не удалось собрать проект!"
    echo ""
    echo "Проверьте наличие ошибок в коде или подключение к интернету."
    echo ""
    read -p "Нажмите Enter для выхода..."
    exit 1
fi

echo "[✓] Проект успешно собран"
echo ""

echo "[3/3] Запуск приложения..."
echo ""
echo "═══════════════════════════════════════════════════════════════"
echo ""

./gradlew run --quiet --console=plain

echo ""
echo "═══════════════════════════════════════════════════════════════"
echo ""
echo "[✓] Выполнение завершено!"
echo ""
read -p "Нажмите Enter для выхода..."
