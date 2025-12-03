package by.gstu.sales;

import by.gstu.sales.processor.CsvReader;
import by.gstu.sales.processor.SalesProcessor;

import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        Properties config = Config.load();
        String csvPath = config.getProperty("csv.input.path");
        char separator = config.getProperty("csv.separator", ",").charAt(0);
        String productId = config.getProperty("filter.product.id");

        var records = CsvReader.readAll(csvPath, separator);
        var processor = new SalesProcessor(records);

        System.out.println("═".repeat(80));
        System.out.println("    ЛАБОРАТОРНАЯ РАБОТА №3 — АГРЕГАТОР ПРОДАЖ (Вариант 5)");
        System.out.println("═".repeat(80));

        System.out.println("\n1. Сумма продаж по регионам:");
        processor.sumByRegion().forEach((r, s) -> System.out.printf("   %s → %.2f ₽%n", r, s));

        System.out.println("\n2. Топ-10 самых дорогих транзакций:");
        processor.topSales(10).forEach(id -> System.out.println("   " + id));

        System.out.println("\n3. Все продажи с ProductID = " + productId + ":");
        processor.filterByProduct(productId)
                .forEach(r -> System.out.printf("   %s | %s | %.2f | %s%n",
                        r.transactionId(), r.date(), r.amount(), r.region()));

        System.out.println("\n" + "═".repeat(80));
        System.out.println("                                  ЧИНАЗЕС!!!    ");
        System.out.println("═".repeat(80));
    }
}