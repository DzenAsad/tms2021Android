package com.myshop.UI.shop.handler.impl;

import com.myshop.UI.shop.handler.ShopHandler;
import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;
import com.myshop.exceptions.shop.ShopProductAlreadyExistsException;
import com.myshop.fabric.Fabrics;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;

public class AddProductShopHandler extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            Product product = (Fabrics.getRequiredFabric(Product.class)).getSomeObject(initData);
            if (!shop.productExist(product)) {
                shop.addProductInShop(product);
            } else {
                System.err.printf("Such product already exist: %s\n", initData);
            }

        } catch (FabricWrongInitDataException | ShopProductAlreadyExistsException e) {
            System.err.println("  Unable to add product in shop");

        }
    }
}
