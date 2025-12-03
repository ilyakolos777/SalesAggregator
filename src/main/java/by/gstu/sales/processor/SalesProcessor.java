package by.gstu.sales.processor;

import by.gstu.sales.model.SaleRecord;

import java.util.*;
import java.util.stream.Collectors;

public class SalesProcessor {
    private final List<SaleRecord> records;

    public SalesProcessor(List<SaleRecord> records) {
        this.records = records;
    }

    public Map<String, Double> sumByRegion() {
        return records.stream()
                .collect(Collectors.groupingBy(
                        SaleRecord::region,
                        Collectors.summingDouble(SaleRecord::amount)
                ));
    }

    public List<String> topSales(int n) {
        return records.stream()
                .sorted(Comparator.comparingDouble(SaleRecord::amount).reversed())
                .limit(n)
                .map(SaleRecord::transactionId)
                .toList();
    }

    public List<SaleRecord> filterByProduct(String id) {
        return records.stream()
                .filter(r -> r.productId().equals(id))
                .toList();
    }
}