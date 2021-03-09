package com.myshop.UI.menu.handler.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;

public class MainMenuHandler extends MenuHandler {

    public MainMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                return MenuOption.MENU_SHOP;
            }
            case ("2"): {
                return MenuOption.MENU_BOOKKEEPING;
            }
            case ("3"): {
                return MenuOption.MENU_OPTION_READER;
            }
            case ("0"): {
                return MenuOption.EXIT;
            }
            default: {
                return MenuOption.MENU_MAIN;
            }
        }
    }
}
