package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public class MenuHandlerBookkeeping extends MenuHandler {
    public MenuHandlerBookkeeping() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
            }
            case ("2"): {
            }
            case ("3"): {
            }
            case ("4"): {
            }
            case ("0"): {
                return MenuCase.MENU_MAIN;
            }
            default: {
                return MenuCase.MENU_BOOKKEEPING;
            }
        }
    }
}

