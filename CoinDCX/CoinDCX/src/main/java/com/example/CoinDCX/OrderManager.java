package com.example.CoinDCX;

import com.google.gson.JsonObject;

public class OrderManager {
    private double triggerPrice;

    public void setTriggerPrice(double triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

    public void processMessage(JsonObject message) {
        // Process the message and prepare payloads for order operations
        double currentPrice = message.get("price").getAsDouble();
        if (currentPrice <= triggerPrice) {
            prepareBuyPayload();
        } else if (currentPrice >= triggerPrice) {
            prepareSellPayload();
        }
    }

    void prepareBuyPayload() {
        // Prepare the payload for a "buy" order
        JsonObject payload = new JsonObject();
        payload.addProperty("id", 2);
        payload.addProperty("method", "place_order");
        payload.addProperty("symbol", "BTC/USDT");
        payload.addProperty("side", "buy");
        payload.addProperty("quantity", 0.01); // Example quantity
        payload.addProperty("price", triggerPrice);

        System.out.println("Buy payload: " + payload);
    }

    void prepareSellPayload() {
        // Prepare the payload for a "sell" order
        JsonObject payload = new JsonObject();
        payload.addProperty("id", 3);
        payload.addProperty("method", "place_order");
        payload.addProperty("symbol", "BTC/USDT");
        payload.addProperty("side", "sell");
        payload.addProperty("quantity", 0.01); // Example quantity
        payload.addProperty("price", triggerPrice);

        System.out.println("Sell payload: " + payload);
    }

    public void prepareCancelPayload(String orderId) {
        // Prepare the payload for canceling an order
        JsonObject payload = new JsonObject();
        payload.addProperty("id", 4);
        payload.addProperty("method", "cancel_order");
        payload.addProperty("orderId", orderId);

        System.out.println("Cancel payload: " + payload);
    }
}
