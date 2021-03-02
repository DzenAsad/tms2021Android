package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Product.ProductWrongInitDataException;
import com.examShop.exceptions.Shop.ShopAlreadyHaveProductException;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public interface AddProductInShop {
    default void addProductInShop(Shop shop, ShopReader optionalReader) {
//        System.out.println("Enter info {id Name price}");
        try {
            for (String initData : optionalReader.someRead()) {
                shop.addProductInShop((FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData));
            }
        } catch (ProductWrongInitDataException | ShopAlreadyHaveProductException e) {
            System.err.println("AddProductInShop fail!");
        } catch (IOException e) {
            System.err.println("No info entered");
        }
    }
}
