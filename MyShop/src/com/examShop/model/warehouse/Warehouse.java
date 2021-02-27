package com.examShop.model.warehouse;

import com.examShop.model.product.Product;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Product, Integer> STOCK = new HashMap<>();

    public void addProductInWarehouse(Product product, int count){
        STOCK.put(product, STOCK.get(product) + count);
    }

    public void removeProductFromWarehouse(Product product){
        STOCK.remove(product);
    }

    public void editProductCountInWarehouse(Product product, int count){
        if (STOCK.get(product) + count >= 0){
            STOCK.replace(product, STOCK.get(product) + count);
        }
    }
}
