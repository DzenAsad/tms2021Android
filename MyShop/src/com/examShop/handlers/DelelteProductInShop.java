package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public interface DelelteProductInShop {
    default void deleteProductInShop(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String string : optionalReader.someRead()) {
                shop.removeProductFromWarehouse(shop.getProduct(Integer.parseInt(string)));
                shop.deleteProductInShop(Integer.parseInt(string));
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException e) {
            System.err.println("Delete product fail!");
        }

    }
}
