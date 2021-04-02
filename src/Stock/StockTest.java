package Stock;

import java.io.IOException;
import java.net.URISyntaxException;

public class StockTest {
    public static void main(String[] args) throws IOException, URISyntaxException {

        String key = "c1jlrmf48v6pv69goegg";
        String code = "AAPL";
        String date_from = "2021-01-02";
        String date_to = "2021-02-02";

        StockContext stockContext = new StockContext();
        stockContext.setStrategy(new Stock_FinnhubAPI());
        Double result = stockContext.executeStrategy(key, code, date_from, date_to);
        System.out.println(result);

    }
}
