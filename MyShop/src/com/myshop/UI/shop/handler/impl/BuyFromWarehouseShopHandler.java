package com.myshop.UI.shop.handler.impl;

import com.myshop.UI.shop.handler.ShopHandler;
import com.myshop.exceptions.shop.ShopProductDoesntExistsException;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;

public class BuyFromWarehouseShopHandler extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        int quantity = 0;
        int money = 0;
        try {
            String[] formattedData = initData.split("\\W+");
            Product product = shop.getProduct(Integer.parseInt(formattedData[0]));
            int count = Integer.parseInt(formattedData[1]);
            if (shop.buyProductFromWarehouse(product, count)) {
                quantity += count;
                money += count * product.getPrice();
            } else {
                System.err.println("No requested quantity in stock ");
            }
        } catch (ShopProductDoesntExistsException e) {
            System.err.println("  Unable to buy product from warehouse");
        } catch (NumberFormatException e) {
            System.err.println("Entered wrong product ID");
        }
        System.out.println("Bought:" + quantity + " Money:" + money);
    }

}
