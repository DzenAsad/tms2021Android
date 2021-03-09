package com.myshop.UI.shop.handler.impl;

import com.myshop.UI.shop.handler.ShopHandler;
import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;
import com.myshop.exceptions.shop.ShopProductDoesntExistsException;
import com.myshop.fabric.Fabrics;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;

public class EditProductShopHandler extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            Product product = Fabrics.getRequiredFabric(Product.class).getSomeObject(initData);
            if (shop.productExist(product)) {
                shop.editProductInShop(product);
            } else {
                System.err.printf("Such product doesn't exist: %s\n", initData);
            }
        } catch (FabricWrongInitDataException | ShopProductDoesntExistsException e) {
            System.err.println("  Unable to edit product in shop");
        }
    }
}
