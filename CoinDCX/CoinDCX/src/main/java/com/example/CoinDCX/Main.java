package com.example.CoinDCX;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        try {
            CoinAPI api = new CoinAPI("api.coindcx.com"); // Use wss scheme
            api.connect();

            OrderManager orderManager = new OrderManager();
            UserInterface userInterface = new UserInterface(api, orderManager);
            userInterface.start();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
