package Stock;

import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StockContext {
    private StockStrategy strategy;

    public StockContext() {
    }

    public void setStrategy(StockStrategy strategy) {
        this.strategy = strategy;
    }

    public HashMap<String, ArrayList<Pair<Date, Double>>> executeStrategy(String key, String code, String date_from, String date_to) throws IOException, URISyntaxException {
        return strategy.execute(key, code, date_from, date_to);
    }
}
