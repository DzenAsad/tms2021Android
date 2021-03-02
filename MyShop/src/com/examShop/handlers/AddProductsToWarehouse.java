package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Product.ProductWrongInitDataException;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public interface AddProductsToWarehouse {
    default void addProductsToWarehouse(Shop shop, ShopReader optionalReader) {
//        System.out.println("Enter info {id count}");
        try {
            for (String initData : optionalReader.someRead()) {
                String[] formattedData = initData.split("\\W+");
                if (formattedData.length != 2) {
                    throw new ProductWrongInitDataException(initData);
                }
                Product product = shop.getProducts(Integer.parseInt(formattedData[0]));
                int count = Integer.parseInt(formattedData[1]);
                    shop.getWarehouse().addProductInWarehouse(product, count);

            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException e) {
            System.err.println("Add product fail!");
        }
    }
}