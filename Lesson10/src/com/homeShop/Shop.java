package com.homeShop;


import java.util.List;

public class Shop {
    private final List<Customer> customers;
    private final List<Cashier> cashiers;
    private final List<String> purchases;

    public Shop(List<Customer> customers, List<Cashier> cashiers, List<String> purchases) {
        this.customers = customers;
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
        for (Customer customer : customers){
            customer.setShop(this);
            customer.start();
        }
    }
}
