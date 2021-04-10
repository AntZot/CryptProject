package Stock;

import java.io.IOException;
import java.net.URISyntaxException;

public class StockTest {
    public static void main(String[] args) throws IOException, URISyntaxException {

        String key = "00a1e69c156a916ffff5c0cc26aaa0e2";
        String code = "AAPL";
        String date_from = "2021-01-02";
        String date_to = "2021-02-02";

        StockContext stockContext = new StockContext();
        stockContext.setStrategy(new Stock_MarketStackAPI());
        Double result = stockContext.executeStrategy(key, code, date_from, date_to);
        System.out.println(result);

    }
}
