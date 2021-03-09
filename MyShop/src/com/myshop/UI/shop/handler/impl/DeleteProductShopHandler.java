package com.myshop.UI.shop.handler.impl;

import com.myshop.UI.shop.handler.ShopHandler;
import com.myshop.exceptions.shop.ShopProductDoesntExistsException;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;

public class DeleteProductShopHandler extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            Product product = shop.getProduct(Integer.parseInt(initData));
            if (shop.productExist(product)) {
                shop.deleteProductInShop(product);
                shop.removeProductFromWarehouse(product);
            } else {
                System.out.printf("Such product doesn't exist: %s\n", initData);
            }
        } catch (ShopProductDoesntExistsException e) {
            System.err.println("  Unable to delete product in shop");
        } catch (NumberFormatException e) {
            System.err.println("Entered wrong product ID");
        }
    }
}
