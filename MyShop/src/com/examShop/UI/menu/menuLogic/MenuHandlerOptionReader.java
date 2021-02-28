package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.fabric.reader.FabricForShopReader;
import com.examShop.model.shop.Shop;

public class MenuHandlerOptionReader extends MenuHandler{
    public MenuHandlerOptionReader(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"):{
                optionalReader = FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.CONSOLE.getThisCase());
                return MenuCase.MENU_OPTION_READER;
            }
            case ("2"): {
                optionalReader = FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.FILE.getThisCase());
                return MenuCase.MENU_OPTION_READER;
            }
            case ("0"): {
                return MenuCase.MENU_MAIN;
            }
            default:{
                return MenuCase.MENU_OPTION_READER;
            }
        }
    }
}
