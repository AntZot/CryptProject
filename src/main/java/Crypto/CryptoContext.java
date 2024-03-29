package Crypto;

import Stock.StockStrategy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

/**
 * Класс паттерна "Стратегия" из которого происходит выбор используемого API
 */
public class CryptoContext {



    private CryptoStrategy strategy;

    public CryptoContext() {
    }

    /**
     * @param strategy - Используемая стратегия (т.е API)
     */
    public void setStrategy(CryptoStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     *
     * @param key - Ключ для работы с API
     * @param code - Кодировка криптоакции
     * @param date_from - Дата с
     * @param date_to - Дата по
     * @return Пока ничего не возвращает - в будущем через другой другой метод будут производиться запросы к базе данных
     * @throws IOException
     * @throws URISyntaxException
     * @throws ParseException
     */
    public Double executeStrategy(String key, String code, String date_from, String date_to) throws IOException, URISyntaxException, ParseException {
        return strategy.execute(key, code, date_from, date_to);
    }
}
