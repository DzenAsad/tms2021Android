package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.menuLogic.MenuHandler;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.model.shop.Shop;

import java.util.Scanner;


public class MainHandler {

    private final Scanner scanner = new Scanner(System.in);

    private MenuHUD m_HUD;
    private MenuCase m_Case;
    private ShopReader optionalReader;
    private Shop shop;

    {
        m_HUD = FabricControl.getRequiredFabric(MenuHUD.class).getSomeObject(FabricControl.FabricCase.MENU_HUD_CONSOLE.toString());
        m_Case = MenuCase.MENU_MAIN;
        optionalReader = FabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricControl.FabricCase.SHOP_READER_FROM_CONSOLE.toString());
        shop = FabricControl.getRequiredFabric(Shop.class).getSomeObject(FabricControl.FabricCase.SHOP.toString());
    }

    public void startProgram() {

        while (m_Case != MenuCase.EXIT) {
            m_HUD.showMenu(m_Case);
            m_Case = menuAction(scanner.next());

        }

    }

    private MenuCase menuAction(String entered_CMD) {
        MenuHandler mh = FabricControl.getRequiredFabric(MenuHandler.class).getSomeObject(m_Case.toString());
        mh.setOptionalReader(optionalReader);
        mh.setShop(shop);
        return mh.casesSwitch(entered_CMD);
    }
}
