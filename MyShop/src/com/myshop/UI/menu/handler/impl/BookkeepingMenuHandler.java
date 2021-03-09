package com.myshop.UI.menu.handler.impl;

import com.myshop.UI.menu.MenuOption;
import com.myshop.UI.menu.handler.MenuHandler;
import com.myshop.model.product.Product;

import java.util.List;

public class BookkeepingMenuHandler extends MenuHandler {
    public BookkeepingMenuHandler() {
    }


    @Override
    public MenuOption casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                System.out.println("Shop have " + getShop().getProductsTypeInShop().size() + " types");
                return MenuOption.MENU_BOOKKEEPING;
            }
            case ("2"): {
                System.out.println("Shop have " + getShop().getAllProductsInShop().size() + " products");
                return MenuOption.MENU_BOOKKEEPING;
            }
            case ("3"): {
                List<Product> tmpList = getShop().getAllProductsInShop();
                System.out.println("Average cost of all Products " + String.format("%(.2f", showAverageCostOfProducts(tmpList)));
                return MenuOption.MENU_BOOKKEEPING;
            }
            case ("4"): {
                List<Product> tmpList = getShop().getAllProductsInShop();
                for (String string : getShop().getProductsTypeInShop()) {
                    System.out.println("Average price for " + string + " is " + String.format("%(.2f", showAverageCostOfProductsByType(tmpList, string)));
                }
                return MenuOption.MENU_BOOKKEEPING;
            }
            case ("0"): {
                return MenuOption.MENU_MAIN;
            }
            default: {
                return MenuOption.MENU_BOOKKEEPING;
            }
        }
    }

    private double showAverageCostOfProducts(List<Product> tmpList) {
        double tmp = 0;
        for (Product product : tmpList) {
            tmp += product.getPrice();
        }
        return tmp / tmpList.size();
    }

    private double showAverageCostOfProductsByType(List<Product> tmpList, String type) {
        double allSum = 0;
        int countProducts = 0;
        for (Product product : tmpList) {
            if (type.equals(product.getType())) {
                allSum += product.getPrice();
                countProducts++;
            }
        }
        return allSum / countProducts;
    }
}

