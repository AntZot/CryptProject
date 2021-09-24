package Stock;

import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Класс паттерна "Стратегия" из которого происходит выбор используемого API
 */
public class StockContext {
    private StockStrategy strategy;

    public StockContext() {
    }

    /**
     * @param strategy - Используемая стратегия (т.е API)
     */
    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * @param key - Ключ для работы с API
     * @param code - Кодировка криптоакции
     * @param date_from - Дата с
     * @param date_to - Дата по
     * @return Пока ничего не возвращает - в будущем через другой другой метод будут производиться запросы к базе данных
     * @throws IOException
     * @throws URISyntaxException
     * @throws ParseException
     */
    public HashMap<String, ArrayList<Pair<Date, Double>>> executeStrategy(String key, String code, String date_from, String date_to) throws IOException, URISyntaxException {
        return strategy.execute(key, code, date_from, date_to);
    }
}
