package Stock;

import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StockTest {
    public static void main(String[] args) throws IOException, URISyntaxException {

        String key = "ad921d5317e6a7ab4996bbb5db5e31c6";
        String code = "AAPL";
        String date_from = "2021-01-02";
        String date_to = "2021-02-02";

        StockContext stockContext = new StockContext();
        stockContext.setStrategy(new Stock_MarketStackAPI());
        HashMap<String, ArrayList<Pair<Date, Double>>> result = stockContext.executeStrategy(key, code, date_from, date_to);
        result.forEach((_key, value) -> System.out.println(key + ":" + value));
    }
}
