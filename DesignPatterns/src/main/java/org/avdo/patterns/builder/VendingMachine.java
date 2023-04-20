package org.avdo.patterns.builder;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private final Map<String, Integer> items;
    int balance;

    private VendingMachine(VendingMachineBuilder builder) {
        this.items = builder.items;
    }

    public void insertCoin(int coin) {
        balance = balance + coin;
    }

    public void selectItem(String itemName) {
        int price = items.getOrDefault(itemName, -1);

        if (price == -1) {
            System.out.println("We don't have that item");
        } else if (balance < price) {
            System.out.println("You don't have enough money");
        } else {
            int change = balance - price;
            balance = 0;
            System.out.println("Here is your item - " + itemName);
            if (change > 0) {
                System.out.println("Your change is " + change);
            }
        }
    }

    public static class VendingMachineBuilder {
        private Map<String, Integer> items = new HashMap<>();

        public VendingMachineBuilder addItem(String itemName, Integer price) {
            items.put(itemName, price);
            return this;
        }

        public VendingMachine build() {
            return new VendingMachine(this);
        }
    }
}
