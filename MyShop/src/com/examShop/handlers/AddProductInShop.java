package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public interface AddProductInShop {
    default void addProductInShop(Shop shop, ShopReader optionalReader) {
        FabricControl fabricControl = new FabricControl();
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string : tmpString) {
            shop.addProductInShop(fabricControl.getRequiredFabric(Product.class).getSomeObject(string));
        }
    }
}
