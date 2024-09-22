package com.example.CoinDCX;

import com.google.gson.JsonObject;

public class Subscribe {
    private CoinAPI api;

    public Subscribe(CoinAPI api) {
        this.api = api;
    }

    public void subscribeToCoin(String symbol) {
        JsonObject message = new JsonObject();
        message.addProperty("id", 1);
        message.addProperty("method", "subscribe");

        JsonObject params = new JsonObject();
        params.addProperty("symbol", symbol);
        message.add("params", params);

        api.send(message.toString()); // Send the subscription message
    }
}