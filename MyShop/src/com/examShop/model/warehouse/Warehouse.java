package com.examShop.model.warehouse;

import com.examShop.model.product.Product;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Product, Integer> STOCK = new HashMap<>();

    public void addProductInWarehouse(Product product, int count){
        if (STOCK.get(product) != null){
            editProductCountInWarehouse(product, count);
        } else {
            STOCK.put(product, count);
        }
    }

    public void removeProductFromWarehouse(Product product){
        STOCK.remove(product);
    }

    public void editProductCountInWarehouse(Product product, int count){
        int curCount = STOCK.get(product);
        if (curCount + count >= 0){
            STOCK.replace(product, curCount + count);
        }
    }

    public int getCountInWarehouse(Product product){
        if (STOCK.get(product) != null){
            return STOCK.get(product);
        }
        return 0;
    }
}
