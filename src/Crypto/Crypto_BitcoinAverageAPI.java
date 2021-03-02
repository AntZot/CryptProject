package Crypto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Crypto_BitcoinAverageAPI implements CryptoStrategy{
    @Override
    public Double execute(String key, String code, String date_from, String date_to) throws URISyntaxException, IOException, ParseException {
        //Значение по умолчанию
        String symbol_set = "global";
        String resolution = "day";
        //Создание URL
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(date_from);
        Long timestamp = date.getTime() / 1000L;
        String bitcoinaverage_uri_template = "https://apiv2.bitcoinaverage.com/indices/" +
                symbol_set +
                "/history/" +
                code +
                "?at=" +
                timestamp.toString() +
                "&resolution=" +
                resolution;
        URIBuilder uri = new URIBuilder(bitcoinaverage_uri_template);
        URL url = uri.build().toURL();
        System.out.println(url.toString());
        //Проверка подключения
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        huc.setRequestMethod("GET");
        huc.setRequestProperty("x-ba-key", key);
        int responseCode = huc.getResponseCode();
        System.out.println(responseCode);
        //Парсинг JSON
        ObjectMapper mapper = new ObjectMapper();
        BitcoinAverageJSON crypto = mapper.readValue(url, BitcoinAverageJSON.class);
        Double price = crypto.average;
        return price;
    }


}
