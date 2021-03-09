package com.myshop.fabric.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.UI.menu.handler.impl.*;
import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.fabric.Fabric;

public class MenuHandlerFabric implements Fabric<MenuHandler> {
    @Override
    public MenuHandler getSomeObject(String initData) {
        switch (MenuOption.valueOf(initData)) {
            case MENU_MAIN: {
                return new MainMenuHandler();
            }
            case MENU_SHOP: {
                return new ShopMenuHandler();
            }
            case MENU_SHOP_PRODUCT_WORK: {
                return new ProductMenuHandler();
            }
            case MENU_SHOP_PRODUCT_SHOW: {
                return new DisplayProductMenuHandler();
            }
            case MENU_SHOP_WAREHOUSE: {
                return new WarehouseMenuHandler();
            }
            case MENU_BOOKKEEPING: {
                return new BookkeepingMenuHandler();
            }
            case MENU_OPTION_READER: {
                return new SelectReaderMenuHandler();
            }
            default: {
                throw new MyShopRuntimeException("ALLAHAKHBAR!");
            }
        }
    }
}
