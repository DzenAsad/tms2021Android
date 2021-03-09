package com.examShop.UI.menu.menuHandler.handler;

import com.examShop.exceptions.Shop.ShopProductAlreadyExistsException;
import com.examShop.exceptions.data.fabric.FabricWrongInitDataException;
import com.examShop.exceptions.data.fabric.product.ProductWrongInitDataException;
import com.examShop.fabric.FabricControl;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

public class ShopHandlerAddProductInShop extends ShopHandler {
    @Override
    public void workLogic(Shop shop, String initData) {
        try {
            Product product = (FabricControl.getRequiredFabric(Product.class)).getSomeObject(initData);
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
