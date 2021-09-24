package Crypto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

/**
 * Интерфейс для паттерна "Стратегия"
 */
public interface CryptoStrategy {
    public Double execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException, ParseException;

}
