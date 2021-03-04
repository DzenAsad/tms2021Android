package com.homeShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Shop {
    List<Cashier> cashiers = new ArrayList<>();
    Queue<Costumer> costumers = new LinkedBlockingQueue<>();
    List<String> productsInShop = new ArrayList<>();

    {
        cashiers.add(new Cashier("#1"));
        cashiers.add(new Cashier("#2"));
        cashiers.add(new Cashier("#3"));

        for (int i = 1; i < 11; i++) {
            costumers.add(new Costumer("Costumer " + i));
        }

        productsInShop.add("Hleb");
        productsInShop.add("Maslo");
        productsInShop.add("Baton");
        productsInShop.add("Milk");
        productsInShop.add("Beer");
        productsInShop.add("Pizza");

        for (Costumer costumer : costumers) {
            Random random = new Random();
            for (int i = 1; i < random.nextInt(5); i++) {
                costumer.addShoppingList(productsInShop.get(random.nextInt(productsInShop.size())));
            }
        }
    }

    public void shopRun() {
        while (!costumers.isEmpty()) {
            if (costumers.poll() != null) {
                getFreeCashier().serveCostumer(costumers.poll());
            }
        }
    }

    public Cashier getFreeCashier() {
        Random random = new Random();
        Cashier tmp = cashiers.get(random.nextInt(cashiers.size()));
        return tmp;
    }
}
