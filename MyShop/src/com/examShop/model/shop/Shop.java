package com.examShop.model.shop;

import com.examShop.exceptions.Shop.ShopAlreadyHaveProduct;
import com.examShop.model.product.Product;
import com.examShop.model.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class Shop {
    private final LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();
    private final Warehouse warehouse = new Warehouse();

    public void addProductInShop(Product product) throws ShopAlreadyHaveProduct {
        if (products.containsKey(product.getID())){
            throw new ShopAlreadyHaveProduct(product);
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

    public LinkedHashMap<Integer, Product> getProducts() {
        return products;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }
}
