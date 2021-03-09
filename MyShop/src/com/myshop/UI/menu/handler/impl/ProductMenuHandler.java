package com.myshop.UI.menu.handler.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.UI.shop.handler.impl.AddProductShopHandler;
import com.myshop.UI.shop.handler.impl.DeleteProductShopHandler;
import com.myshop.UI.shop.handler.impl.EditProductShopHandler;


public class ProductMenuHandler extends MenuHandler {
    public ProductMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                System.out.println("Enter info \"id_name_type_price\"");
                cycleHandler(new AddProductShopHandler());
                return MenuOption.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                System.out.println("Enter info \"id\"");
                cycleHandler(new DeleteProductShopHandler());
                return MenuOption.MENU_SHOP_PRODUCT_WORK;
            }
            case ("3"): {
                System.out.println("Enter info \"id_name_type_price\"");
                cycleHandler(new EditProductShopHandler());
                return MenuOption.MENU_SHOP_PRODUCT_WORK;
            }
            case ("0"): {
                return MenuOption.MENU_SHOP;
            }
            default: {
                return MenuOption.MENU_SHOP_PRODUCT_WORK;
            }
        }
    }
}
