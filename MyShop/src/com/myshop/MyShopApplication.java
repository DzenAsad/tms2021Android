package com.myshop;

import com.myshop.UI.menu.Menu;
import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.UI.menu.reader.MyShopReader;
import com.myshop.exceptions.MyShopRuntimeException;
import com.myshop.exceptions.data.fabric.FabricWrongInitDataException;
import com.myshop.fabric.FabricVariants;
import com.myshop.fabric.Fabrics;
import com.myshop.model.shop.Shop;

import java.util.Scanner;


public class MyShopApplication {

    public static MyShopReader optionalReader;
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu;
    private final Shop shop;
    private MenuOption menuOption;

    {
        try {
            menu = Fabrics.getRequiredFabric(Menu.class).getSomeObject(FabricVariants.MENU_HUD_CONSOLE.toString());
            menuOption = MenuOption.MENU_MAIN;
            optionalReader = Fabrics.getRequiredFabric(MyShopReader.class).getSomeObject(FabricVariants.SHOP_READER_FROM_CONSOLE.toString());
            shop = Fabrics.getRequiredFabric(Shop.class).getSomeObject(FabricVariants.SHOP.toString());
        } catch (FabricWrongInitDataException e) {
            throw new MyShopRuntimeException("Unable to initialise application");
        }
    }

    public void startProgram() {
        try {
            while (menuOption != MenuOption.EXIT) {
                menu.showMenu(menuOption);
                menuOption = menuAction(scanner.nextLine());

            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private MenuOption menuAction(String enteredCommand) {
        MenuHandler menuHandler;
        try {
            menuHandler = Fabrics.getRequiredFabric(MenuHandler.class).getSomeObject(menuOption.toString());
        } catch (FabricWrongInitDataException e) {
            throw new MyShopRuntimeException("Unable to find handler for selected menu item");
        }
        menuHandler.setOptionalReader(optionalReader);
        menuHandler.setShop(shop);
        return menuHandler.casesSwitch(enteredCommand);
    }
}
