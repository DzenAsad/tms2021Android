package com.examShop.fabric.menu;

import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.MenuHUD_Console;
import com.examShop.fabric.Fabric;

public class FabricForMenuHUD implements Fabric<MenuHUD> {
    @Override
    public MenuHUD getSomeObject(String initData) {
        switch (initData) {
            case ("MENU_HUD_CONSOLE"): {
                return new MenuHUD_Console();
            }
            default: {
                return null;
            }
        }
    }
}
