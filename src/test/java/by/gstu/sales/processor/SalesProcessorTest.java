package by.gstu.sales.processor;

import by.gstu.sales.model.SaleRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SalesProcessorTest {

    private SalesProcessor processor;

    // Универсальный метод для создания мокового SaleRecord
    private SaleRecord createRecord(String transactionId, String date,
                                    String productId, double amount, String region) throws Exception {
        SaleRecord r = new SaleRecord();

        Field tid = SaleRecord.class.getDeclaredField("transactionId");
        tid.setAccessible(true);
        tid.set(r, transactionId);

        Field d = SaleRecord.class.getDeclaredField("date");
        d.setAccessible(true);
        d.set(r, date);

        Field pid = SaleRecord.class.getDeclaredField("productId");
        pid.setAccessible(true);
        pid.set(r, productId);

        Field a = SaleRecord.class.getDeclaredField("amount");
        a.setAccessible(true);
        a.set(r, amount);

        Field reg = SaleRecord.class.getDeclaredField("region");
        reg.setAccessible(true);
        reg.set(r, region);

        return r;
    }

    @BeforeEach
    void setUp() throws Exception {
        List<SaleRecord> mockData = List.of(
                createRecord("T001", "2025-01-01", "P-123", 1000.0, "North"),
                createRecord("T002", "2025-01-02", "P-456", 2500.0, "South"),
                createRecord("T003", "2025-01-03", "P-123", 3000.0, "North"),
                createRecord("T004", "2025-01-04", "P-789",  500.0, "West"),
                createRecord("T005", "2025-01-05", "P-123", 4000.0, "North"),
                createRecord("T006", "2025-01-06", "P-123", 1500.0, "Center")
        );

        processor = new SalesProcessor(mockData);
    }

    @Test
    void testSumByRegion() {
        Map<String, Double> sums = processor.sumByRegion();

        assertEquals(8000.0, sums.get("North"),  0.01); // 1000 + 3000 + 4000
        assertEquals(2500.0, sums.get("South"),  0.01);
        assertEquals(500.0,  sums.get("West"),   0.01);
        assertEquals(1500.0, sums.get("Center"), 0.01);
    }

    @Test
    void testTopSales() {
        List<String> top = processor.topSales(10);

        assertEquals("T005", top.get(0)); // 4000
        assertEquals("T003", top.get(1)); // 3000
        assertEquals("T002", top.get(2)); // 2500
    }

    @Test
    void testFilterByProduct() {
        List<SaleRecord> filtered = processor.filterByProduct("P-123");

        assertEquals(4, filtered.size()); // T001, T003, T005, T006
        assertTrue(filtered.stream().allMatch(r -> "P-123".equals(r.productId())));
    }
}