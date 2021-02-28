package com.examShop.UI.menu.menuLogic;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.model.shop.Shop;

public class MenuHandlerOptionReader extends MenuHandler {
    public MenuHandlerOptionReader() {
    }

    public MenuHandlerOptionReader(Shop shop, ShopReader optionalReader) {
        super(shop, optionalReader);
    }

    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                setOptionalReader(FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricControl.FabricCase.SHOP_READER_FROM_CONSOLE.toString()));
                return MenuCase.MENU_OPTION_READER;
            }
            case ("2"): {
                setOptionalReader(FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricControl.FabricCase.SHOP_READER_FROM_FILE.toString()));
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
