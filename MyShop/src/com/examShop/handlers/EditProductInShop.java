package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public interface EditProductInShop {
    default void editProductInShop(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String string : optionalReader.someRead()) {
                shop.editProductInShop(FabricControl.getRequiredFabric(Product.class).getSomeObject(string));
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        }
    }
}
