package com.examShop.model.shop;

import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.model.product.Product;
import com.examShop.model.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class Shop {
    private final LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();
    private final Warehouse warehouse = new Warehouse();

    public boolean addProductInShop(Product product) {
        if (products.containsKey(product.getID())) {
            return false;
        }
        products.put(product.getID(), product);
        return true;
    }

    public List<Product> getAllProductsInShop() {
        return new ArrayList<>(products.values());
    }

    public boolean deleteProductInShop(int id) throws ShopNotHaveProductException {
        products.remove(id);
        return checkProduct(id);
    }

    public boolean editProductInShop(Product product) throws ShopNotHaveProductException {
        products.put(product.getID(), product);
        removeProductFromWarehouse(product);
        return checkProduct(product.getID());
    }

    public Product getProduct(int id) throws ShopNotHaveProductException {
        return products.get(id);
    }

    public void addProductInWarehouse(Product product, int count) {
        warehouse.addProduct(product, count);
    }

    public void removeProductFromWarehouse(Product product) {
        warehouse.removeProduct(product);
    }

    public boolean buyProductFromWarehouse(Product product, int count) {
        return warehouse.editProductCount(product, -count);
    }

    public int getCountInWarehouse(Product product) {
        return warehouse.getCount(product);
    }

    private boolean checkProduct(int id) {
        return products.containsKey(id);
    }
}
