package com.examShop.UI.menu;

public class MenuHUD_Console extends MenuHUD {

    @Override
    public void showMenu(MenuCase menuCase) {
        switch (menuCase) {
            case MENU_MAIN -> {
                System.out.println("1. Shop");
                System.out.println("2. Bookkeeping");
                System.out.println("3. Chose reader");
                System.out.println("0. Exit");
            }
            case MENU_SHOP -> {
                System.out.println("1. Work with products");
                System.out.println("2. Show products");
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
