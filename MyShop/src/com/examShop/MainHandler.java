package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.fabric.menu.FabricForMenuHUD;
import com.examShop.fabric.reader.FabricForShopReader;

import java.util.Scanner;


public class MainHandler {
    private boolean flag = true;
    private final FabricControl fabricControl = new FabricControl();
    Scanner scanner = new Scanner(System.in);
    private MenuHUD m_HUD = fabricControl.getRequiredFabric(MenuHUD.class).getSomeObject(FabricForMenuHUD.FabricCase.CONSOLE.getThisCase());
    private ShopReader optionalReader;
    private MenuCase menuCase = MenuCase.MENU_MAIN;

    public void startProgram(){

        while (flag) {
            m_HUD.showMenu(menuCase);
            menuAction(scanner.next());
        }

    }


    private void menuAction(String enteredCMD) {
        switch (menuCase) {
            case MENU_MAIN: {
                if (enteredCMD.equals("1")) {
                    menuCase = MenuCase.MENU_SHOP;
                    return;
                }
                if (enteredCMD.equals("2")) {
                    menuCase = MenuCase.MENU_BOOKKEEPING;
                    return;
                }
                if (enteredCMD.equals("3")) {
                    menuCase = MenuCase.MENU_OPTION_READER;
                    return;
                }
                if (enteredCMD.equals("0")) {
                    flag = false;
                }
            }
            case MENU_SHOP: {
                if (enteredCMD.equals("1")) {
                    menuCase = MenuCase.MENU_SHOP_PRODUCT_WORK;
                    return;
                }
                if (enteredCMD.equals("2")) {
                    menuCase = MenuCase.MENU_SHOP_PRODUCT_SHOW;
                    return;
                }
                if (enteredCMD.equals("0")) {
                    menuCase = MenuCase.MENU_MAIN;
                    return;
                }
            }
            case MENU_SHOP_PRODUCT_WORK: {
                if (enteredCMD.equals("1")) {
                    return;
                }
                if (enteredCMD.equals("2")) {
                    return;
                }
                if (enteredCMD.equals("3")) {
                    return;
                }
                if (enteredCMD.equals("0")) {
                    menuCase = MenuCase.MENU_SHOP;
                    return;
                }
            }
            case MENU_SHOP_PRODUCT_SHOW: {
                if (enteredCMD.equals("1")) {
                    return;
                }
                if (enteredCMD.equals("2")) {
                    return;
                }
                if (enteredCMD.equals("0")) {
                    menuCase = MenuCase.MENU_SHOP;
                    return;
                }
            }
            case MENU_BOOKKEEPING: {
                if (enteredCMD.equals("0")) {
                    menuCase = MenuCase.MENU_MAIN;
                    return;
                }
            }
            case MENU_OPTION_READER: {
                if (enteredCMD.equals("1")) {
                    optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.CONSOLE.getThisCase());
                    return;
                }
                if (enteredCMD.equals("2")) {
                    optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.FILE.getThisCase());
                    return;
                }
                if (enteredCMD.equals("0")) {
                    menuCase = MenuCase.MENU_MAIN;
                    return;
                }
            }
        }
    }
}
