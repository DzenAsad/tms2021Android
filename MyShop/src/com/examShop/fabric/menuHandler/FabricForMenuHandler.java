package com.examShop.fabric.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.menuLogic.*;
import com.examShop.fabric.Fabric;

public class FabricForMenuHandler implements Fabric<MenuHandler> {
    @Override
    public MenuHandler getSomeObject(String initData) {
        switch (MenuCase.valueOf(initData)) {
            case MENU_MAIN: {
                return new MenuHandlerMain();
            }
            case MENU_SHOP: {
                return new MenuHandlerShop();
            }
            case MENU_SHOP_PRODUCT_WORK: {
                return new MenuHandlerShopProductWork();
            }
            case MENU_SHOP_PRODUCT_SHOW: {
                return new MenuHandlerShopProductShow();
            }
            case MENU_SHOP_WAREHOUSE: {
                return new MenuHandlerShopWarehouse();
            }
            case MENU_BOOKKEEPING: {
                return new MenuHandlerBookkeeping();
            }
            case MENU_OPTION_READER: {
                return new MenuHandlerOptionReader();
            }
            default: {
                throw new NullPointerException();
            }
        }
    }
}
