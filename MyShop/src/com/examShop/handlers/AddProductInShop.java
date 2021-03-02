package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Product.NullProductException;
import com.examShop.exceptions.Shop.ShopAlreadyHaveProduct;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public interface AddProductInShop {
    default void addProductInShop(Shop shop, ShopReader optionalReader) {
//        System.out.println("Enter info {id Name price}");
        List<String> tmpString = new LinkedList<>();
        //Read data
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }

        for (String initData : tmpString) {
            try {
                shop.addProductInShop((FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData));
            } catch (NullProductException | ShopAlreadyHaveProduct e){
                System.err.println("AddProductInShop fail!");
            }
        }
    }
}
