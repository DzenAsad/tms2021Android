package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuHandlerBookkeeping extends MenuHandler {
    public MenuHandlerBookkeeping() {
    }


    @Override
    public MenuCase casesSwitch(String command) {
        switch (command) {
            case ("1"): {
                System.out.println("Shop have " + getShop().getProductsTypeInShop().size() + " types");
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("2"): {
                System.out.println("Shop have " + getShop().getAllProductsInShop().size() + " products");
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("3"): {
                List<Product> tmpList = getShop().getAllProductsInShop();
                System.out.println("Average cost of all Products " + String.format("%(.2f", showAverageCostOfProducts(tmpList)));
                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("4"): {
                List<Product> tmpList = getShop().getAllProductsInShop();
                for (String string: getShop().getProductsTypeInShop()) {
                    System.out.println("Average price for " + string + " is " + String.format("%(.2f", showAverageCostOfProductsByType(tmpList, string)));
                }

                return MenuCase.MENU_BOOKKEEPING;
            }
            case ("0"): {
                return MenuCase.MENU_MAIN;
            }
            default: {
                return MenuCase.MENU_BOOKKEEPING;
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

