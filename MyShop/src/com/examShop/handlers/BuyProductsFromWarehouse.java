package com.examShop.handlers;

import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.Shop.ShopNotHaveProductException;
import com.examShop.exceptions.Warehouse.WarehouseWrongInitDataException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;

public interface BuyProductsFromWarehouse {
    default void buyProductsFromWarehouse(Shop shop, ShopReader optionalReader) {
        System.out.println("Enter info");
        try {
            for (String initData : optionalReader.someRead()) {
                String[] formattedData = initData.split("\\W+");
                if (formattedData.length != 2) {
                    throw new WarehouseWrongInitDataException(initData);
                }
                try {
                    Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
                    int count = Integer.parseInt(formattedData[1]);
                    shop.editProductCountInWarehouse(product, -count);
                } catch (NumberFormatException e) {
                    throw new WarehouseWrongInitDataException(initData);
                }
            }
        } catch (IOException e) {
            System.err.println("No info entered");
        } catch (ShopNotHaveProductException | WarehouseWrongInitDataException e) {
            System.err.println("Add product fail!");
        }

    }
}
