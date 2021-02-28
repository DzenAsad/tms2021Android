package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public interface BuyProductsFromWarehouse {
    default void buyProductsFromWarehouse(Shop shop, ShopReader optionalReader){
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string: tmpString){
            String[] formattedData = string.split("\\W+");
            Product product = shop.getProducts().get(Integer.parseInt(formattedData[0]));
            int count = Integer.parseInt(formattedData[1]);
            if (product  != null){
                shop.getWarehouse().editProductCountInWarehouse(product, -count);
            }
        }
    }
}
