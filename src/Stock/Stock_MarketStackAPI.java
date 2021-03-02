package Stock;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import Stock.MarketStackJSON;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class Stock_MarketStackAPI implements StockStrategy{


    @Override
    public Double execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException {
        //Создание URL
        URIBuilder uri = new URIBuilder("http://api.marketstack.com/v1/eod")
                .addParameter("access_key", key)
                .addParameter("symbols", code)
                .addParameter("date_from", date_from)
                .addParameter("date_to", date_to);
        URL url = uri.build().toURL();
        //Проверка подключения
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        int responseCode = huc.getResponseCode();
        System.out.println(responseCode);
        //Парсинг JSON
        ObjectMapper mapper = new ObjectMapper();
        MarketStackJSON stock = mapper.readValue(url, MarketStackJSON.class);
        Date date = stock.getData().get(stock.getData().size() - 1).date;
        Double price = stock.getData().get(stock.getData().size() - 1).close;
        return price;
    }
}
