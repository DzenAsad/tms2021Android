package com.examShop.fabric.menu;

import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.MenuHUD_Console;
import com.examShop.exceptions.MyShopRuntimeException;
import com.examShop.fabric.Fabric;
import com.examShop.fabric.FabricCase;

public class FabricForMenuHUD implements Fabric<MenuHUD> {
    @Override
    public MenuHUD getSomeObject(String initData) {
        switch (FabricCase.valueOf(initData)) {
            case MENU_HUD_CONSOLE: {
                return new MenuHUD_Console();
            }
            default: {
                throw new MyShopRuntimeException("The end is coming... amen...");
            }
        }
    }
}
