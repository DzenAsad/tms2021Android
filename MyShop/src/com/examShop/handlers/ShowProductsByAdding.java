package com.examShop.handlers;

import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.util.List;

public interface ShowProductsByAdding {
    default void showProductsByAdding(Shop shop){
        List<Product> tmpString = shop.getAllProductsInShop();
        for(Product product: tmpString){
            System.out.println(product.toString() + " In warehouse:" + shop.getWarehouse().getCountInWarehouse(product));
        }
    }
}
