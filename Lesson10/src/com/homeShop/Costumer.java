package com.homeShop;

import java.util.LinkedList;
import java.util.List;

public class Costumer extends Thread{
    private final String nameCostumer;
    List<String> shoppingList = new LinkedList<>();

    public Costumer(String nameCostumer) {
        this.nameCostumer = nameCostumer;
    }

    public void addShoppingList(String product) {
        shoppingList.add(product);
    }

    public String getNameCostumer() {
        return nameCostumer;
    }

    public List<String> getShoppingList() {
        return shoppingList;
    }


    @Override
    public void run() {
        for (String str:  shoppingList){
            System.out.println(nameCostumer + ": " + str);
        }
    }


}
