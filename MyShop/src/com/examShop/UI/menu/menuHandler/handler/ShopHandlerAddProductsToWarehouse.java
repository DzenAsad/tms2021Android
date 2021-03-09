package com.examShop.UI.menu.menuHandler.handler;

import com.examShop.exceptions.Shop.ShopProductDoesntExistsException;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public class ShopHandlerAddProductsToWarehouse extends ShopHandler {
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
