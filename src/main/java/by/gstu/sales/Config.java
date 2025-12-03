package by.gstu.sales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    public static Properties load() throws IOException {
        Properties prop = new Properties();
        prop.load(Files.newInputStream(Paths.get("app.properties")));
        return prop;
    }
}