package Stock;

import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface StockStrategy {
    public HashMap<String, ArrayList<Pair<Date, Double>>> execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException;

}
