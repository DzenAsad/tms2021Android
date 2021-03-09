package com.myshop.UI.menu.handler.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.UI.shop.handler.impl.AddToWarehouseShopHandler;
import com.myshop.UI.shop.handler.impl.BuyFromWarehouseShopHandler;

public class WarehouseMenuHandler extends MenuHandler {
    public WarehouseMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                System.out.println("Enter info \"id_count\"");
                cycleHandler(new AddToWarehouseShopHandler());
                return MenuOption.MENU_SHOP_WAREHOUSE;
            }
            case ("2"): {
                System.out.println("Enter info \"id_count\"");
                cycleHandler(new BuyFromWarehouseShopHandler());
                return MenuOption.MENU_SHOP_WAREHOUSE;
            }
            case ("0"): {
                return MenuOption.MENU_SHOP;
            }
            default: {
                return MenuOption.MENU_SHOP_WAREHOUSE;
            }
        }
    }

}
