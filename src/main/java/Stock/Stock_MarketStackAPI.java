package Stock;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Stock_MarketStackAPI implements StockStrategy{


    @Override
    public HashMap<String, ArrayList<Pair<Date, Double>>> execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException {
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


        HashMap<String, ArrayList<Pair<Date, Double>>> stock_data = new HashMap<>();
        ArrayList<Pair<Date, Double>> stock_pair = new ArrayList();
        for (int i = 0; i < stock.getData().size(); i++) {
            Date date = stock.getData().get(i).date;
            double price = stock.getData().get(stock.getData().size() - 1).close;
            Pair<Date, Double> date_price = new ImmutablePair<>(date, price);
            stock_pair.add(date_price);
        }
        String symbol = stock.getData().get(stock.getData().size() - 1).symbol;
        stock_data.put(symbol, stock_pair);
        return stock_data;
    }
}
