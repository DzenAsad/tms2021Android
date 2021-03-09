package com.myshop.fabric.impl;

import com.myshop.UI.menu.ConsoleMenu;
import com.myshop.UI.menu.Menu;
import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.fabric.Fabric;
import com.myshop.fabric.FabricVariants;

public class MenuFabric implements Fabric<Menu> {
    @Override
    public Menu getSomeObject(String initData) {
        switch (FabricVariants.valueOf(initData)) {
            case MENU_HUD_CONSOLE: {
                return new ConsoleMenu();
            }
            default: {
                throw new MyShopRuntimeException("The end is coming... amen...");
            }
        }
    }
}
