package ru.mirea.team_project;


import Crypto.CryptoTest;
import DataBase.DatabaseHandler;
import DataBase.TestRun;
import GUI.GUI;
import Stock.StockTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //TestRun.main();
        try {
            StockTest.main(args);
        }catch (Exception e){
            e.printStackTrace();
        }
        GUI.main(args);
    }
}
