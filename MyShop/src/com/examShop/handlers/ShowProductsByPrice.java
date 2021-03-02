package com.examShop.handlers;

import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.util.Comparator;
import java.util.List;

public interface ShowProductsByPrice {
    default void showProductsByPrice(Shop shop) {
        List<Product> tmpString = shop.getAllProductsInShop();
        tmpString.sort(Comparator.comparingInt(Product::getPrice));
        for (Product product : tmpString) {
            System.out.println(product.toString() + " In warehouse:" + shop.getCountInWarehouse(product));
        }
    }
}
