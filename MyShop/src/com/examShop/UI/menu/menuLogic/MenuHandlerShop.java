package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public class MenuHandlerShop extends MenuHandler {
    public MenuHandlerShop() {
    }

    public MenuHandlerShop(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
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
