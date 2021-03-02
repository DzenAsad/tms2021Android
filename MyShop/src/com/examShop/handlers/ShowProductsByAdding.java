package com.examShop.handlers;

import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public interface ShowProductsByAdding {
    default void showProductsByAdding(Shop shop) {
        for (Product product : shop.getAllProductsInShop()) {
            System.out.println(product.toString() + " In warehouse:" + shop.getCountInWarehouse(product));
        }
    }
}
