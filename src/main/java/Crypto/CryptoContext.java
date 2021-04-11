package Crypto;

import Stock.StockStrategy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

public class CryptoContext {
    private CryptoStrategy strategy;

    public CryptoContext() {
    }

    public void setStrategy(CryptoStrategy strategy) {
        this.strategy = strategy;
    }

    public Double executeStrategy(String key, String code, String date_from, String date_to) throws IOException, URISyntaxException, ParseException {
        return strategy.execute(key, code, date_from, date_to);
    }
}
