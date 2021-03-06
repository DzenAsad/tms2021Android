package com.examShop.UI.menu.menuHandler;

import com.examShop.UI.menu.MenuCase;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.util.List;

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
                showAverageCostOfProductsByType(getShop());
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

    private void showCountOfAllTypes(Shop shop) {
        System.out.println("Shop have " + shop.getProductsTypeInShop().size() + " types");
    }

    private void showCountOfAllProducts(Shop shop) {
        System.out.println("Shop have " + shop.getAllProductsInShop().size() + " products");
    }

    private void showAverageCostOfProducts(Shop shop) {
        List<Product> tmpList = shop.getAllProductsInShop();
        double tmp = 0;
        for (Product product : tmpList) {
            tmp += product.getPrice();
        }
        tmp = tmp / tmpList.size();

        System.out.println("Average cost of all Products " + String.format("%(.2f", tmp));
    }

    private void showAverageCostOfProductsByType(Shop shop) {
        for (String type : shop.getProductsTypeInShop()) {
            double allSum = 0;
            int countProducts = 0;
            for (Product product : shop.getAllProductsInShop()) {
                if (type.equals(product.getType())) {
                    allSum += product.getPrice();
                    countProducts++;
                }
            }
            System.out.println("Average price for " + type + " is " + String.format("%(.2f", allSum / countProducts));
        }
    }
}

