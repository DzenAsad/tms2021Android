package com.examShop.model.warehouse;

import com.examShop.model.product.Product;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Product, Integer> stock = new HashMap<>();

    public void storeProduct(Product product, int count) {
        boolean flag = existInWarehouse(product);
        if (flag) {
            editProductCount(product, count);
        } else {
            stock.put(product, count);
        }
    }

    public void removeProduct(Product product) {
        stock.remove(product);
    }

    public boolean editProductCount(Product product, int count) {
        int curCount = stock.get(product);
        if (curCount + count >= 0) {
            stock.put(product, curCount + count);
            return true;
        }
        return false;
    }

    public int getCount(Product product) {
        if (stock.get(product) != null) {
            return stock.get(product);
        }
        return 0;
    }

    private boolean existInWarehouse(Product product) {
        return stock.containsKey(product);
    }
}
