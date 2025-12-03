// src/main/java/by/gstu/sales/model/SaleRecord.java
package by.gstu.sales.model;

import com.opencsv.bean.CsvBindByName;

public class SaleRecord {

    @CsvBindByName(column = "TransactionID")
    private String transactionId;

    @CsvBindByName(column = "Date")
    private String date;

    @CsvBindByName(column = "ProductID")
    private String productId;

    @CsvBindByName(column = "Amount")
    private double amount;

    @CsvBindByName(column = "Region")
    private String region;

    // ОБЯЗАТЕЛЬНО НУЖЕН ПУСТОЙ КОНСТРУКТОР!
    public SaleRecord() {}

    // Геттеры (OpenCSV их использует)
    public String transactionId() { return transactionId; }
    public String date() { return date; }
    public String productId() { return productId; }
    public double amount() { return amount; }
    public String region() { return region; }

    @Override
    public String toString() {
        return String.format("%s | %s | %.2f | %s", transactionId, date, amount, region);
    }
}