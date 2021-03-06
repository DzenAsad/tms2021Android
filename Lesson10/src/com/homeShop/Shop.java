package com.homeShop;


import java.util.List;

public class Shop {
    List<Costumer> costumers;
    List<Cashier> cashiers;
    List<String> purchases;

    public Shop(List<Costumer> costumers, List<Cashier> cashiers, List<String> purchases) {
        this.costumers = costumers;
        this.cashiers = cashiers;
        this.purchases = purchases;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public List<String> getPurchases() {
        return purchases;
    }

    public void shopRun(){
        for (Costumer costumer: costumers){
            costumer.setShop(this);
            costumer.start();
        }
    }
}
