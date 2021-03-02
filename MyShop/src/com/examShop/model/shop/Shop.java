package com.examShop.model.shop;

import com.examShop.exceptions.Shop.ShopAlreadyHaveProductException;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.model.product.Product;
import com.examShop.model.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class Shop {
    private final LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();
    private final Warehouse warehouse = new Warehouse();

    public void addProductInShop(Product product) throws ShopAlreadyHaveProductException {
        if (products.containsKey(product.getID())){
            throw new ShopAlreadyHaveProductException(product);
        }
        products.put(product.getID(), product);
    }

    public List<Product> getAllProductsInShop() {
        return new ArrayList<>(products.values());
    }

    public void deleteProductInShop(int id) {
        products.remove(id);
    }

    public void editProductInShop(Product product) {
        products.put(product.getID(), product);
    }

    public Product getProducts(int id) throws ShopNotHaveProductException {
        Product tmp = products.get(id);
        if (tmp != null){
            return tmp;
        } else {
            throw new ShopNotHaveProductException(id);
        }
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
