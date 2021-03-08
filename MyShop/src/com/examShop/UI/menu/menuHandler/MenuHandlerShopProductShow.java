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
    public MenuCase casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                List<Product> tmpString = getShop().getAllProductsInShop();
                tmpString.sort(Comparator.comparingInt(Product::getPrice));
                showProducts(getShop(), tmpString);
                return MenuCase.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("2"): {
                List<Product> tmpString = getShop().getAllProductsInShop();
                showProducts(getShop(), tmpString);
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

    private void showProducts(Shop shop, List<Product> list){
        for (Product product : list) {
            System.out.println(product.toString() + " In warehouse:" + shop.getCountInWarehouse(product));
        }
    }

}
