package com.myshop.UI.shop.handler.impl;

import com.myshop.UI.shop.handler.ShopHandler;
import com.myshop.exceptions.shop.ShopProductDoesntExistsException;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;

public class AddToWarehouseShopHandler extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            String[] formattedData = initData.split("\\W+");
            Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
            int count = Integer.parseInt(formattedData[1]);
            shop.addProductInWarehouse(product, count);

        } catch (ShopProductDoesntExistsException e) {
            System.err.println("  Unable to add product to warehouse");
        } catch (NumberFormatException e) {
            System.err.println("Entered wrong product ID");
        }
    }
}
