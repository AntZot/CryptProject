package Stock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public interface StockStrategy {
    public Double execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException;

}
