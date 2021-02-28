package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.menuLogic.*;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.fabric.menu.FabricForMenuHUD;
import com.examShop.fabric.reader.FabricForShopReader;
import com.examShop.fabric.shop.FabricForShop;
import com.examShop.model.shop.Shop;

import java.util.Scanner;


public class MainHandler {

    private final FabricControl fabricControl = new FabricControl();
    private final Scanner scanner = new Scanner(System.in);

    private MenuHUD m_HUD;
    private MenuCase m_Case;
    private ShopReader optionalReader;
    private Shop shop;

    {
        m_HUD = fabricControl.getRequiredFabric(MenuHUD.class).getSomeObject(FabricForMenuHUD.FabricCase.CONSOLE.getThisCase());
        m_Case = MenuCase.MENU_MAIN;
        optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.CONSOLE.getThisCase());
        shop = fabricControl.getRequiredFabric(Shop.class).getSomeObject(FabricForShop.FabricCase.SHOP.getThisCase());
    }

    public void startProgram() {

        while (m_Case != MenuCase.EXIT) {
            m_HUD.showMenu(m_Case);
            m_Case = menuAction(scanner.next());

        }

    }


    private MenuCase menuAction(String entered_CMD) {
        switch (m_Case) {
            case MENU_MAIN: {
                return new MenuHandlerMain(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_SHOP: {
                return new MenuHandlerShop(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_SHOP_PRODUCT_WORK: {
                return new MenuHandlerShopProductWork(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_SHOP_PRODUCT_SHOW: {
                return new MenuHandlerShopProductShow(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_SHOP_WAREHOUSE: {
                return new MenuHandlerShopWarehouse(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_BOOKKEEPING: {
                return new MenuHandlerBookkeeping(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_OPTION_READER: {
                return new MenuHandlerOptionReader(shop, optionalReader).casesSwitch(entered_CMD);
            }
            default: {
                return m_Case;
            }
        }
    }
}
