package com.examShop.model.warehouse;

import com.examShop.model.product.Product;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Product, Integer> STOCK = new HashMap<>();

    public void addProduct(Product product, int count) {
        if (STOCK.get(product) != null) {
            editProductCount(product, count);
        } else {
            STOCK.put(product, count);
        }
    }

    public void removeProduct(Product product) {
        STOCK.remove(product);
    }

    public void editProductCount(Product product, int count) {
        int curCount = STOCK.get(product);
        if (curCount + count >= 0) {
            STOCK.replace(product, curCount + count);
        }
    }

    public int getCount(Product product) {
        if (STOCK.get(product) != null) {
            return STOCK.get(product);
        }
        return 0;
    }
}
