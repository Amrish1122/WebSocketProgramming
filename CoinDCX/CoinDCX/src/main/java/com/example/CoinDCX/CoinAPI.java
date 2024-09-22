package com.example.CoinDCX;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class CoinAPI extends WebSocketClient {
    private static Logger logger = LoggerFactory.getLogger(CoinAPI.class);
    private Subscribe subscribe;
    private OrderManager orderManager;

    public CoinAPI(URI serverUri) {
        super(serverUri);
        this.subscribe = new Subscribe(this);
        this.orderManager = new OrderManager();
    }

    public CoinAPI(String url) throws URISyntaxException {
        super(new URI("wss://" + url)); // Use wss scheme for HTTPS
        this.subscribe = new Subscribe(this);
        this.orderManager = new OrderManager();
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        logger.info("connection established");
        subscribe.subscribeToCoin("BTC"); // Subscribe to BTC/USDT market data
    }

    @Override
    public void onMessage(String s) {
        // Process the message and prepare payloads
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("connection closed :: " + s);
    }

    @Override
    public void onError(Exception e) {
        logger.info("error occured \n" + e.getMessage());
    }

    public void send(String message) {
        super.send(message); // Send the message to the WebSocket
    }
}