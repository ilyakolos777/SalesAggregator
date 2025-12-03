package by.gstu.sales.processor;

import by.gstu.sales.model.SaleRecord;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvReader {
    public static List<SaleRecord> readAll(String path, char separator) throws Exception {
        try (FileReader reader = new FileReader(path)) {
            return new CsvToBeanBuilder<SaleRecord>(reader)
                    .withType(SaleRecord.class)
                    .withSeparator(separator)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }
    }
}