package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.menuHandler.MenuHandler;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricCase;
import com.examShop.fabric.FabricControl;
import com.examShop.model.shop.Shop;

import java.util.Scanner;


public class MainHandler {

    private final Scanner scanner = new Scanner(System.in);
    private final MenuHUD menuHUD;
    private MenuCase menuCase;
    public static ShopReader optionalReader;
    private final Shop shop;

    {
        menuHUD = FabricControl.getRequiredFabric(MenuHUD.class).getSomeObject(FabricCase.MENU_HUD_CONSOLE.toString());
        menuCase = MenuCase.MENU_MAIN;
        optionalReader = FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricCase.SHOP_READER_FROM_CONSOLE.toString());
        shop = FabricControl.getRequiredFabric(Shop.class).getSomeObject(FabricCase.SHOP.toString());
    }

    public void startProgram() {

        while (menuCase != MenuCase.EXIT) {
            menuHUD.showMenu(menuCase);
            menuCase = menuAction(scanner.next());

        }

    }

    private MenuCase menuAction(String enteredCommand) {
        MenuHandler menuHandler = FabricControl.getRequiredFabric(MenuHandler.class).getSomeObject(menuCase.toString());
        menuHandler.setOptionalReader(optionalReader);
        menuHandler.setShop(shop);
        return menuHandler.casesSwitch(enteredCommand);
    }
}
