package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.util.Comparator;
import java.util.List;

public class MenuHandlerShopProductShow extends MenuHandler {
    public MenuHandlerShopProductShow() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                showProductsByPrice(getShop());
                return MenuCase.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("2"): {
                showProductsByAdding(getShop());
                return MenuCase.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default: {
                return MenuCase.MENU_SHOP_PRODUCT_SHOW;
            }
        }
    }

    private void showProductsByAdding(Shop shop) {
        for (Product product : shop.getAllProductsInShop()) {
            System.out.println(product.toString() + " In warehouse:" + shop.getCountInWarehouse(product));
        }
    }

    private void showProductsByPrice(Shop shop) {
        List<Product> tmpString = shop.getAllProductsInShop();
        tmpString.sort(Comparator.comparingInt(Product::getPrice));
        for (Product product : tmpString) {
            System.out.println(product.toString() + " In warehouse:" + shop.getCountInWarehouse(product));
        }
    }
}
