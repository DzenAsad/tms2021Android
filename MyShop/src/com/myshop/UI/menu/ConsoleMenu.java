package com.myshop.UI.menu;

public class ConsoleMenu extends Menu {

    @Override
    public void showMenu(MenuOption menuOption) {
        switch (menuOption) {
            case MENU_MAIN -> {
                System.out.println("1. Shop");
                System.out.println("2. Bookkeeping");
                System.out.println("3. Chose reader");
                System.out.println("0. Exit");
            }
            case MENU_SHOP -> {
                System.out.println("1. Work with Products");
                System.out.println("2. Show Products");
                System.out.println("3. Warehouse");
                System.out.println("0 Back");
            }
            case MENU_SHOP_PRODUCT_WORK -> {
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. Edit Product");
                System.out.println("0 Back");
            }
            case MENU_SHOP_PRODUCT_SHOW -> {
                System.out.println("1. Show Products by price");
                System.out.println("2. Show Products by adding");
                System.out.println("0 Back");
            }
            case MENU_BOOKKEEPING -> {
                System.out.println("1. Number of Product types");
                System.out.println("2. Number of Products");
                System.out.println("3. Average price of Products");
                System.out.println("4. Average price of Products by types");
                System.out.println("0 Back");
            }
            case MENU_OPTION_READER -> {
                System.out.println("1. Console Reader");
                System.out.println("2. File Reader");
                System.out.println("0 Back");
            }
            case MENU_SHOP_WAREHOUSE -> {
                System.out.println("1. Add Product to Warehouse");
                System.out.println("2. Buy from Warehouse");
                System.out.println("0 Back");
            }
        }
    }
}
