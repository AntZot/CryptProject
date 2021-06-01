package Crypto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

public class CryptoTest {
    public static void main(String[] args) throws IOException, URISyntaxException, ParseException {
        String key = "MjRiNzQ4ZDZkYmEyNDhiY2E0MGM0ZDA5MWFjMWUyNTQ";
        String symbol_set = "global";
        String symbol = "BTCUSD";
        String timestamp = "1612203788";
        String resolution = "day";
        String time_from = "2021-01-02";

        CryptoContext cryptoContext = new CryptoContext();
        cryptoContext.setStrategy(new Crypto_BitcoinAverageAPI());
        Double result = cryptoContext.executeStrategy(key, symbol, time_from, "");
        System.out.println(result);
    }
}
