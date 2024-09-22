package com.example.CoinDCX;

import java.util.Scanner;

public class UserInterface {
    private CoinAPI api;
    private OrderManager orderManager;

    public UserInterface(CoinAPI api, OrderManager orderManager) {
        this.api = api;
        this.orderManager = orderManager;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trigger price: ");
        double triggerPrice = scanner.nextDouble();
        orderManager.setTriggerPrice(triggerPrice);

        while (true) {
            System.out.print("Enter command (buy, sell, cancel, or exit): ");
            String command = scanner.next();
            if (command.equals("exit")) {
                break;
            } else if (command.equals("buy")) {
                // Simulate a buy order
                orderManager.prepareBuyPayload();
            } else if (command.equals("sell")) {
                // Simulate a sell order
                orderManager.prepareSellPayload();
            } else if (command.equals("cancel")) {
                System.out.print("Enter order ID to cancel: ");
                String orderId = scanner.next();
                orderManager.prepareCancelPayload(orderId);
            }
        }
    }
}
