package Stock;

import java.io.IOException;
import java.net.URISyntaxException;

public class StockContext {
    private StockStrategy strategy;

    public StockContext() {
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    public Double executeStrategy(String key, String code, String date_from, String date_to) throws IOException, URISyntaxException {
        return strategy.execute(key, code, date_from, date_to);
    }
}
