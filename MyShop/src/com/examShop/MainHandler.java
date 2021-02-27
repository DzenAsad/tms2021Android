package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.reader.ShopReader;
import com.examShop.fabric.FabricControl;
import com.examShop.fabric.menu.FabricForMenuHUD;
import com.examShop.fabric.reader.FabricForShopReader;
import com.examShop.fabric.shop.FabricForShop;
import com.examShop.model.product.Product;
import com.examShop.model.shop.Shop;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MainHandler {
    private boolean flag = true;

    private final FabricControl fabricControl = new FabricControl();
    private final Scanner scanner = new Scanner(System.in);

    private MenuHUD m_HUD;
    private MenuCase menuCase;
    private ShopReader optionalReader;
    private Shop shop;

    {
        m_HUD = fabricControl.getRequiredFabric(MenuHUD.class).getSomeObject(FabricForMenuHUD.FabricCase.CONSOLE.getThisCase());
        menuCase = MenuCase.MENU_MAIN;
        optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.CONSOLE.getThisCase());
        shop = fabricControl.getRequiredFabric(Shop.class).getSomeObject(FabricForShop.FabricCase.SHOP.getThisCase());
    }

    public void startProgram() {

        while (flag) {
            m_HUD.showMenu(menuCase);
            menuAction(scanner.next());
        }

    }


    private void menuAction(String entered_CMD) {
        switch (menuCase) {
            case MENU_MAIN: {
                if (entered_CMD.equals("1")) {
                    menuCase = MenuCase.MENU_SHOP;
                    return;
                }
                if (entered_CMD.equals("2")) {
                    menuCase = MenuCase.MENU_BOOKKEEPING;
                    return;
                }
                if (entered_CMD.equals("3")) {
                    menuCase = MenuCase.MENU_OPTION_READER;
                    return;
                }
                if (entered_CMD.equals("0")) {
                    flag = false;
                }
            }
            case MENU_SHOP: {
                if (entered_CMD.equals("1")) {
                    menuCase = MenuCase.MENU_SHOP_PRODUCT_WORK;
                    return;
                }
                if (entered_CMD.equals("2")) {
                    menuCase = MenuCase.MENU_SHOP_PRODUCT_SHOW;
                    return;
                }
                if (entered_CMD.equals("0")) {
                    menuCase = MenuCase.MENU_MAIN;
                    return;
                }
            }
            case MENU_SHOP_PRODUCT_WORK: {
                if (entered_CMD.equals("1")) {
                    addProductInShop();
                    return;
                }
                if (entered_CMD.equals("2")) {
                    deleteProductInShop();
                    return;
                }
                if (entered_CMD.equals("3")) {
                    editProductInShop();
                    return;
                }
                if (entered_CMD.equals("0")) {
                    menuCase = MenuCase.MENU_SHOP;
                    return;
                }
            }
            case MENU_SHOP_PRODUCT_SHOW: {
                if (entered_CMD.equals("1")) {
                    showProductsByPrice();
                    return;
                }
                if (entered_CMD.equals("2")) {
                    return;
                }
                if (entered_CMD.equals("0")) {
                    menuCase = MenuCase.MENU_SHOP;
                    return;
                }
            }
            case MENU_BOOKKEEPING: {
                if (entered_CMD.equals("0")) {
                    menuCase = MenuCase.MENU_MAIN;
                    return;
                }
            }
            case MENU_OPTION_READER: {
                if (entered_CMD.equals("1")) {
                    optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.CONSOLE.getThisCase());
                    return;
                }
                if (entered_CMD.equals("2")) {
                    optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.FILE.getThisCase());
                    return;
                }
                if (entered_CMD.equals("0")) {
                    menuCase = MenuCase.MENU_MAIN;
                    return;
                }
            }
        }
    }


    private void addProductInShop() {
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string : tmpString) {
            shop.addProductInShop(fabricControl.getRequiredFabric(Product.class).getSomeObject(string));
        }
    }

    private void deleteProductInShop(){
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string : tmpString) {
            shop.deleteProductInShop(Integer.parseInt(string));
        }
    }

    private void editProductInShop(){
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string : tmpString) {
            shop.editProductInShop(fabricControl.getRequiredFabric(Product.class).getSomeObject(string));
        }
    }

    private void showProductsByPrice(){
        List<Product> tmpString = shop.getAllProductsInShop();
        tmpString.sort(Comparator.comparingInt(Product::getPrice));
        for(Product product: tmpString){
            System.out.println(product.toString());
        }
    }

}
