package com.myshop.UI.menu.handler.impl;

import com.myshop.MyShopApplication;
import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.UI.menu.reader.MyShopReader;
import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;
import com.myshop.fabric.FabricVariants;
import com.myshop.fabric.Fabrics;

public class SelectReaderMenuHandler extends MenuHandler {
    public SelectReaderMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        try {
            switch (command) {
                case ("1"): {
                    MyShopApplication.optionalReader = (Fabrics.getRequiredFabric(MyShopReader.class).getSomeObject(FabricVariants.SHOP_READER_FROM_CONSOLE.toString()));
                    return MenuOption.MENU_OPTION_READER;
                }
                case ("2"): {
                    MyShopApplication.optionalReader = (Fabrics.getRequiredFabric(MyShopReader.class).getSomeObject(FabricVariants.SHOP_READER_FROM_FILE.toString()));
                    return MenuOption.MENU_OPTION_READER;
                }
                case ("0"): {
                    return MenuOption.MENU_MAIN;
                }
                default: {
                    return MenuOption.MENU_OPTION_READER;
                }
            }
        } catch (FabricWrongInitDataException e) {
            throw new MyShopRuntimeException("Unable to get reader");
        }
    }
}
