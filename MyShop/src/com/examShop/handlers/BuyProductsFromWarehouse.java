package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public interface BuyProductsFromWarehouse {
    default void buyProductsFromWarehouse(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String string : optionalReader.someRead()) {
                String[] formattedData = string.split("\\W+");
                Product product = shop.getProducts(Integer.parseInt(formattedData[0]));
                int count = Integer.parseInt(formattedData[1]);
                if (product != null) {
                    shop.getWarehouse().editProductCountInWarehouse(product, -count);
                }
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException e) {
            System.err.println("Add product fail!");
        }

    }
}
