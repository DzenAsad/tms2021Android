package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricCase;
import com.examShop.fabric.FabricControl;

public class MenuHandlerOptionReader extends MenuHandler {
    public MenuHandlerOptionReader() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                setOptionalReader(FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricCase.SHOP_READER_FROM_CONSOLE.toString()));
                return MenuCase.MENU_OPTION_READER;
            }
            case ("2"): {
                setOptionalReader(FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricCase.SHOP_READER_FROM_FILE.toString()));
                return MenuCase.MENU_OPTION_READER;
            }
            case ("0"): {
                return MenuCase.MENU_MAIN;
            }
            default: {
                return MenuCase.MENU_OPTION_READER;
            }
        }
    }
}
