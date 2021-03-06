package com.homeShop;

import java.util.LinkedList;
import java.util.Queue;

public class Cashier {
    private final String name;
    private final Queue<Costumer> queue= new LinkedList<>();

    public Cashier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void serve(Costumer costumer){
        synchronized (queue) {
            costumer.buy();
            queue.remove();
        }
    }

    public Costumer iAmFirst() {
        synchronized (queue) {
            return queue.peek();
        }
    }

    public void getInLine(Costumer costumer) {
        queue.add(costumer);
    }

    public int getQueueCount(){
        return queue.size();
    }
}



