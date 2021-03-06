package com.examShop.model.warehouse;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Integer, Integer> stock = new HashMap<>();

    public boolean addProduct(int product, int count) {
        boolean flag = checkWarehouse(product);
        if (flag) {
            editProductCount(product, count);
        } else {
            stock.put(product, count);
        }
        return flag;
    }

    public void removeProduct(int product) {
        stock.remove(product);
    }

    public boolean editProductCount(int product, int count) {
        int curCount = stock.get(product);
        if (curCount + count >= 0) {
            stock.put(product, curCount + count);
            return true;
        }
        return false;
    }

    public int getCount(int product) {
        if (stock.get(product) != null) {
            return stock.get(product);
        }
        return 0;
    }

    private boolean checkWarehouse(int id) {
        return stock.containsKey(id);
    }
}
