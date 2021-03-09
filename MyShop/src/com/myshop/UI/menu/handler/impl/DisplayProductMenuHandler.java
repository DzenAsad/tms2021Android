package com.myshop.UI.menu.handler.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.model.product.Product;
import com.myshop.model.shop.Shop;

import java.util.Comparator;
import java.util.List;

public class DisplayProductMenuHandler extends MenuHandler {
    public DisplayProductMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                List<Product> tmpString = getShop().getAllProductsInShop();
                tmpString.sort(Comparator.comparingInt(Product::getPrice));
                showProducts(getShop(), tmpString);
                return MenuOption.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("2"): {
                List<Product> tmpString = getShop().getAllProductsInShop();
                showProducts(getShop(), tmpString);
                return MenuOption.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("0"): {
                return MenuOption.MENU_SHOP;
            }
            default: {
                return MenuOption.MENU_SHOP_PRODUCT_SHOW;
            }
        }
    }

    private void showProducts(Shop shop, List<Product> list) {
        for (Product product : list) {
            System.out.println(product.toString() + " In warehouse:" + shop.getCountInWarehouse(product));
        }
    }

}
