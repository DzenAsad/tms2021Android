package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public interface AddProductsToWarehouse {
    default void addProductsToWarehouse(Shop shop, ShopReader optionalReader) {
//        System.out.println("Enter info {id count}");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String initData : tmpString) {
            String[] formattedData = initData.split("\\W+");
            Product product = shop.getProducts().get(Integer.parseInt(formattedData[0]));
            int count = Integer.parseInt(formattedData[1]);
            if (product != null) {
                shop.getWarehouse().addProductInWarehouse(product, count);
            } else {
                System.err.println("Can't add \"" + initData + "\", Product with this info not exist!");
            }
        }

    }
}
