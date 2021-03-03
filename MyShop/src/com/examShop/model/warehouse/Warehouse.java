package com.examShop.model.warehouse;

import com.examShop.exceptions.Warehouse.WarehouseNotHaveProductIdException;
import com.examShop.model.product.Product;

import java.util.HashMap;

public class Warehouse {
    private final HashMap<Integer, Integer> stock = new HashMap<>();

    public void addProduct(Product product, int count) {
        if (stock.get(product.getID()) != null) {
            editProductCount(product, count);
        } else {
            stock.put(product.getID(), count);
        }
    }

    public void removeProduct(Product product) {
        stock.remove(product.getID());
    }

    public void editProductCount(Product product, int count) {
        int curCount = stock.get(product.getID());
        if (curCount + count >= 0) {
            stock.replace(product.getID(), curCount + count);
        }
    }

    public int getCount(Product product) {
        if (stock.get(product.getID()) != null) {
            return stock.get(product.getID());
        }
        return 0;
    }

    private void checkProduct(int id) throws WarehouseNotHaveProductIdException {
        if (stock.get(id) == null) {
            throw new WarehouseNotHaveProductIdException(id);
        }
    }
}
