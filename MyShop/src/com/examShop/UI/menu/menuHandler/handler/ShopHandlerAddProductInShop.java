package com.examShop.UI.menu.menuHandler.handler;

import com.examShop.exceptions.Product.ProductWrongInitDataException;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public class ShopHandlerAddProductInShop extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            if (!shop.addProductInShop((FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData))) {
                System.out.println(("Add fail, wrong data - " + initData));
            }
        } catch (ProductWrongInitDataException e) {
            System.err.println(" Add fail!");
        }
    }
}
