package com.examShop.model.warehouse;

import com.examShop.model.product.Product;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Integer, Integer> stock = new HashMap<>();

    public void addProduct(Product product, int count) {
        if (checkWarehouse(product.getID())) {
            editProductCount(product, count);
        } else {
            stock.put(product.getID(), count);
        }
    }

    public void removeProduct(Product product) {
        stock.remove(product.getID());
    }

    public boolean editProductCount(Product product, int count) {
        int curCount = stock.get(product.getID());
        if (curCount + count >= 0) {
            stock.put(product.getID(), curCount + count);
            return true;
        }
        return false;
    }

    public int getCount(Product product) {
        if (stock.get(product.getID()) != null) {
            return stock.get(product.getID());
        }
        return 0;
    }

    private boolean checkWarehouse(int id){
        return stock.containsKey(id);
    }
}
