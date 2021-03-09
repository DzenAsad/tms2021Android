package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.menuHandler.MenuHandler;
import com.examShop.UI.reader.ShopReader;
import com.examShop.exceptions.data.fabric.FabricWrongInitDataException;
import com.examShop.fabric.FabricCase;
import com.examShop.fabric.FabricControl;
import com.examShop.model.shop.Shop;

import java.util.Scanner;


public class MainHandler {

    public static ShopReader optionalReader;
    private final Scanner scanner = new Scanner(System.in);
    private MenuHUD menuHUD;
    private Shop shop;
    private MenuCase menuCase;

    {
        try {
            menuHUD = FabricControl.getRequiredFabric(MenuHUD.class).getSomeObject(FabricCase.MENU_HUD_CONSOLE.toString());
            menuCase = MenuCase.MENU_MAIN;
            optionalReader = FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricCase.SHOP_READER_FROM_CONSOLE.toString());
            shop = FabricControl.getRequiredFabric(Shop.class).getSomeObject(FabricCase.SHOP.toString());
        } catch (FabricWrongInitDataException fabricWrongInitDataException) {
            fabricWrongInitDataException.printStackTrace();
        }
    }

    public void startProgram() {
        try {
            while (menuCase != MenuCase.EXIT) {
                menuHUD.showMenu(menuCase);
                menuCase = menuAction(scanner.nextLine());

            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private MenuCase menuAction(String enteredCommand) {
        MenuHandler menuHandler = null;
        try {
            menuHandler = FabricControl.getRequiredFabric(MenuHandler.class).getSomeObject(menuCase.toString());
        } catch (FabricWrongInitDataException fabricWrongInitDataException) {
            fabricWrongInitDataException.printStackTrace();
        }
        menuHandler.setOptionalReader(optionalReader);
        menuHandler.setShop(shop);
        return menuHandler.casesSwitch(enteredCommand);
    }
}
