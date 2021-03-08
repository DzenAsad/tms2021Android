package com.examShop.UI.menu.menuHandler.handler;

import com.examShop.exceptions.Shop.ShopNullProductException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public class ShopHandlerBuyProductsFromWarehouse extends ShopHandler {
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
        } catch (ShopNullProductException e) {
            System.err.println(" Buy product fail!");
        } catch (NumberFormatException e) {
            System.err.println("Wrong input!");
        }
        System.out.println("Bought:" + quantity + " Money:" + money);
    }

}
