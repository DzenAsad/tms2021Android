package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;

public class MenuHandlerShop extends MenuHandler {
    public MenuHandlerShop() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                return MenuCase.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("3"): {
                return MenuCase.MENU_SHOP_WAREHOUSE;
            }
            case ("0"): {
                return MenuCase.MENU_MAIN;
            }
            default: {
                return MenuCase.MENU_SHOP;
            }
        }
    }
}
