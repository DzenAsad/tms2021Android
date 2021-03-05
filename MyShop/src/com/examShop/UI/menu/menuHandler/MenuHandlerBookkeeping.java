package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.model.shop.Shop;

public class MenuHandlerBookkeeping extends MenuHandler {
    public MenuHandlerBookkeeping() {
    }


    @Override
    public MenuCase casesSwitch(String cmd) {
        switch (cmd) {
            case ("1"): {
                showCountOfAllTypes(getShop());
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("2"): {
                showCountOfAllProducts(getShop());
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("3"): {
                showAverageCostOfProducts(getShop());
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("4"): {
            }
            case ("0"): {
                return MenuCase.MENU_MAIN;
            }
            default: {
                return MenuCase.MENU_BOOKKEEPING;
            }
        }
    }

    private void showCountOfAllTypes(Shop shop) {
        System.out.println("Shop have " + shop.getCountProductsTypeInShop() + " types");
    }

    private void showCountOfAllProducts(Shop shop) {
        System.out.println("Shop have " + shop.getCountProductsInShop() + " products");
    }

    private void showAverageCostOfProducts(Shop shop){
        System.out.println("Average cost of all Products " + shop.getAveragedCostProducts());
    }
}

