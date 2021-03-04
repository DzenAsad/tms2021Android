package com.homeShop;


public class Cashier {
    private final String name;
    private int countQueue = 0;
    private Object isWork = new Object();

    public Cashier(String name) {
        this.name = name;
    }

    public void serveCostumer(Costumer costumer) {
        increaseCountQueue();

        synchronized (isWork){
            System.out.println("Cashier " + name);
            costumer.run();
        }
        synchronized (name) {
            countQueue--;
        }
    }

    public void increaseCountQueue() {
        synchronized (name) {
            countQueue++;
        }
    }

    public int getCountQueue() {
        return countQueue;
    }
}



