package Stock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;

/**
 * Интерфейс для паттерна "Стратегия"
 */
public interface StockStrategy {
    public Double execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException, ParseException;

}
