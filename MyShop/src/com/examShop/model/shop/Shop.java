package com.examShop.model.shop;

import com.examShop.model.product.Product;

import java.util.*;


public class Shop {
    LinkedHashMap<Integer, Product> products = new LinkedHashMap<>();

    public void addProductInShop(Product product) {

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
}
