# SalesAggregator
Лабораторная работа №3 — Агрегатор CSV-данных о продажах (вариант 5)

[![Build & Test](https://github.com/ilyakolos777/SalesAggregator/actions/workflows/main.yml/badge.svg)](https://github.com/ilyakolos777/SalesAggregator/actions/workflows/main.yml)

**Предмет:** Инструменты поддержки промышленной разработки ПО  
**Выполнил:** Колос Илья [ИТП-31]  
**Технологии:** Java 17 • Gradle • OpenCSV • JUnit 5 • GitHub Actions

## Что делает программа
Приложение читает CSV-файл с данными о продажах и выводит:
1. Сумму продаж по регионам  
2. Топ-10 самых дорогих транзакций (по TransactionID)  
3. Все продажи с заданным ProductID (настраивается в `app.properties`)

## Как запустить — пошагово

1. Скачайте проект с GitHub  
   Нажмите зелёную кнопку **Code → Download ZIP**

2. Распакуйте архив в любую папку (например, на Рабочий стол)

3. Откройте терминал / командную строку  
   - **macOS**: `Cmd + Пробел` → введите `Terminal`  
   - **Windows**: `Win + R` → введите `cmd`

4. Перейдите в папку с проектом  
   Просто перетащите распакованную папку в окно терминала — путь вставится автоматически  
   Или вручную:
   cd ~/Desktop/SalesAggregator-main

   cd C:\Users\ВашеИмя\Desktop\SalesAggregator-main

5. Запустите проект
   - **macOS/Linux**: ./gradlew build, затем ./gradlew run
   - **Windows**: gradlew build, затем build run

Готово! В консоль будет выведен статистический отчет.

### Важно
- Java и Gradle устанавливать **НЕ нужно** — всё уже внутри проекта  
- IntelliJ IDEA открывать **НЕ нужно** — работает из коробки  
- CI/CD на GitHub Actions настроен и проходит успешно (зелёная галочка вверху)  

**Проект запускается сразу после скачивания — 100% проверено на стороннем компьютере**

### Настройка (если нужно поменять под свои цели)
Файл `app.properties` лежит в корне проекта:

```properties
csv.input.path=data/sales.csv
csv.separator=,
filter.product.id=P-123
