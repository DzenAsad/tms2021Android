package com.examShop.UI.menu.menuHandler.handler;

import com.examShop.model.shop.Shop;

public class ShopHandlerDeleteProductInShop extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            if (!shop.deleteProductInShop(Integer.parseInt(initData))) {
                System.out.println("Delete fail, wrong data - " + initData);
            }
            shop.removeProductFromWarehouse(Integer.parseInt(initData));
        } catch (NumberFormatException e) {
            System.err.println(" Wrong info.");
        }
    }
}
