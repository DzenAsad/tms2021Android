package com.homeShop;

import java.util.LinkedList;
import java.util.Queue;

public class Cashier {
    private final String name;
    private final Queue<Customer> queue= new LinkedList<>();

    public Cashier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void serve(Customer customer){
        synchronized (queue) {
            customer.buy(this);
            queue.remove();
        }
    }

    public Customer iAmFirst() {
        synchronized (queue) {
            return queue.peek();
        }
    }

    public void getInLine(Customer customer) {
        queue.add(customer);
    }

    public int getQueueCount(){
        return queue.size();
    }
}



