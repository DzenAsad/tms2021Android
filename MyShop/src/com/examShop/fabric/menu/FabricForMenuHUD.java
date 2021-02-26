package com.examShop.fabric.menu;

import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.MenuHUD_Console;
import com.examShop.fabric.Fabric;

public class FabricForMenuHUD implements Fabric<MenuHUD> {
    @Override
    public MenuHUD getSomeObject(String initData) {
        if (initData.equals("MenuHUD_Console")){
            return new MenuHUD_Console();
        } else {
            return null;
        }
    }

    public enum FabricCase{
        CONSOLE ("MenuHUD_Console");

        private final String someCase;

        FabricCase(String someCase) {
            this.someCase = someCase;
        }

        public String getThisCase(){
            return someCase;
        }
    }
}
