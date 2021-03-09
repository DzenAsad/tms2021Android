package com.myshop.UI.menu.handler.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;

public class ShopMenuHandler extends MenuHandler {
    public ShopMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                return MenuOption.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                return MenuOption.MENU_SHOP_PRODUCT_SHOW;
            }
            case ("3"): {
                return MenuOption.MENU_SHOP_WAREHOUSE;
            }
            case ("0"): {
                return MenuOption.MENU_MAIN;
            }
            default: {
                return MenuOption.MENU_SHOP;
            }
        }
    }
}
