package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.model.shop.Shop;

public class MenuData_MENU_MAIN extends MenuData{


    public MenuData_MENU_MAIN(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                return MenuCase.MENU_SHOP;
            }
            case ("2"): {
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("3"): {
                return MenuCase.MENU_OPTION_READER;
            }
            case ("0"): {
                return MenuCase.EXIT;
            }
        }
        return null;
    }
}
