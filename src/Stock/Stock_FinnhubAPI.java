package Stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.ParseException;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock_FinnhubAPI implements StockStrategy{
    @Override
    public Double execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException, java.text.ParseException {
        //Работа с датами
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d_from = format.parse(date_from);
        Date d_to = format.parse(date_to);
        Long timestamp_from = d_from.getTime() / 1000L;
        Long timestamp_to = d_to.getTime() / 1000L;

        //Создание URL
        URIBuilder uri_builder = new URIBuilder("https://finnhub.io/api/v1/forex/candle")
                .addParameter("symbol", code)
                .addParameter("resolution", "1")
                .addParameter("from", timestamp_from.toString())
                .addParameter("to", timestamp_to.toString())
                .addParameter("token", key);
        URL url = new URL(URLDecoder.decode(uri_builder.build().toString(), StandardCharsets.UTF_8));
        System.out.println(url);
        //Проверка подключения
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        int responseCode = huc.getResponseCode();
        System.out.println(responseCode);
        //Парсинг JSON
        ObjectMapper mapper = new ObjectMapper();
        Root stock = mapper.readValue(url, Root.class);
        System.out.println(stock.s);
        return 0.0;
    }
}

