package com.homeShop;


import java.util.List;
import java.util.Random;

public class Customer extends Thread {
    private List<String> purchases;
    private Shop shop;

    public Customer(String name) {
        super(name);
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Cashier choiceCashier(List<Cashier> cashiers) {
//        Cashier tmp = cashiers.get(0);
//        int count = 0;
//        for (Cashier cashier: cashiers){
//            if (cashier.getQueueCount() < count){
//                count = cashier.getQueueCount();
//                tmp = cashier;
//            }
//        }
//        return tmp;

        Random random = new Random();
        return cashiers.get(random.nextInt(cashiers.size()));
    }

    public void buy(Cashier cashier) {
        for (String string : purchases) {
            System.out.println(getName() + " buy " + string + " in " + cashier.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        purchases = shop.getPurchases();
        Cashier cashier = choiceCashier(shop.getCashiers());
        cashier.getInLine(this);
        cashier.serve();


    }
}
