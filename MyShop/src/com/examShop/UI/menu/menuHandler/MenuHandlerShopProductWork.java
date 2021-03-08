package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.menuHandler.handler.ShopHandlerAddProductInShop;
import com.examShop.UI.menu.menuHandler.handler.ShopHandlerDeleteProductInShop;
import com.examShop.UI.menu.menuHandler.handler.ShopHandlerEditProductInShop;


public class MenuHandlerShopProductWork extends MenuHandler {
    public MenuHandlerShopProductWork() {
    }


    @Override
    public MenuCase casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                System.out.println("Enter info \"id_name_type_price\"");
                cycleHandler(new ShopHandlerAddProductInShop());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("2"): {
                System.out.println("Enter info \"id\"");
                cycleHandler(new ShopHandlerDeleteProductInShop());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("3"): {
                System.out.println("Enter info \"id_name_type_price\"");
                cycleHandler(new ShopHandlerEditProductInShop());
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
            case ("0"): {
                return MenuCase.MENU_SHOP;
            }
            default: {
                return MenuCase.MENU_SHOP_PRODUCT_WORK;
            }
        }
    }
}
