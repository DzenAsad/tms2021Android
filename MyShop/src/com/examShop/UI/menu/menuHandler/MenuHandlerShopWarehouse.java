package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.menuHandler.handler.ShopHandlerAddProductsToWarehouse;
import com.examShop.UI.menu.menuHandler.handler.ShopHandlerBuyProductsFromWarehouse;

public class MenuHandlerShopWarehouse extends MenuHandler {
    public MenuHandlerShopWarehouse() {
    }


    @Override
    public MenuCase casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                System.out.println("Enter info \"id_count\"");
                cycleHandler(new ShopHandlerAddProductsToWarehouse());
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
            case ("2"): {
                System.out.println("Enter info \"id_count\"");
                cycleHandler(new ShopHandlerBuyProductsFromWarehouse());
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default: {
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
        }
    }

}
