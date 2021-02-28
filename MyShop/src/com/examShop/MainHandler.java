package com.examShop;

import com.examShop.UI.menu.MenuCase;
import com.examShop.UI.menu.MenuHUD;
import com.examShop.UI.menu.menuLogic.MenuData;
import com.examShop.UI.menu.menuLogic.MenuData_MENU_MAIN;
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

        while (menuCase != MenuCase.EXIT) {
            m_HUD.showMenu(menuCase);
            menuCase = menuAction(scanner.next());

        }

    }


    private MenuCase menuAction(String entered_CMD) {
        switch (menuCase) {
            case MENU_MAIN: {
                return new MenuData_MENU_MAIN(shop, optionalReader).casesSwitch(entered_CMD);
            }
            case MENU_SHOP: {
                if (entered_CMD.equals("1")) {
                    return MenuCase.MENU_SHOP_PRODUCT_WORK;
                }
                if (entered_CMD.equals("2")) {
                    return MenuCase.MENU_SHOP_PRODUCT_SHOW;
                }
                if (entered_CMD.equals("3")) {
                    return MenuCase.MENU_SHOP_WAREHOUSE;
                }
                if (entered_CMD.equals("0")) {
                    return MenuCase.MENU_MAIN;
                }
            }
            case MENU_SHOP_PRODUCT_WORK: {
                if (entered_CMD.equals("1")) {
                    addProductInShop();
                    return menuCase;
                }
                if (entered_CMD.equals("2")) {
                    deleteProductInShop();
                    return menuCase;
                }
                if (entered_CMD.equals("3")) {
                    editProductInShop();
                    return menuCase;
                }
                if (entered_CMD.equals("0")) {
                    return MenuCase.MENU_SHOP;
                }
            }
            case MENU_SHOP_PRODUCT_SHOW: {
                if (entered_CMD.equals("1")) {
                    showProductsByPrice();
                    return menuCase;
                }
                if (entered_CMD.equals("2")) {
                    showProductsByAdding();
                    return menuCase;
                }
                if (entered_CMD.equals("0")) {
                    return MenuCase.MENU_SHOP;
                }
            }
            case MENU_SHOP_WAREHOUSE: {
                if (entered_CMD.equals("1")) {
                    addProductsToWarehouse();
                    return menuCase;
                }
                if (entered_CMD.equals("2")) {
                    buyProductsFromWarehouse();
                    return menuCase;
                }
                if (entered_CMD.equals("0")) {
                    return MenuCase.MENU_SHOP;
                }
            }
            case MENU_BOOKKEEPING: {
                if (entered_CMD.equals("0")) {
                    return MenuCase.MENU_MAIN;
                }
            }
            case MENU_OPTION_READER: {
                if (entered_CMD.equals("1")) {
                    optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.CONSOLE.getThisCase());
                    return menuCase;
                }
                if (entered_CMD.equals("2")) {
                    optionalReader = fabricControl.getRequiredFabric(ShopReader.class).getSomeObject(FabricForShopReader.FabricCase.FILE.getThisCase());
                    return menuCase;
                }
                if (entered_CMD.equals("0")) {
                    return MenuCase.MENU_MAIN;
                }
            }
            default: {
                return menuCase;
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
            shop.getWarehouse().removeProductFromWarehouse(shop.getProducts().get(Integer.parseInt(string)));
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
            System.out.println(product.toString() + " In warehouse:" + shop.getWarehouse().getCountInWarehouse(product));
        }
    }

    private void showProductsByAdding(){
        List<Product> tmpString = shop.getAllProductsInShop();
        for(Product product: tmpString){
            System.out.println(product.toString() + " In warehouse:" + shop.getWarehouse().getCountInWarehouse(product));
        }
    }

    private void addProductsToWarehouse(){
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string: tmpString){
            String[] formattedData = string.split("\\W+");
            Product product = shop.getProducts().get(Integer.parseInt(formattedData[0]));
            int count = Integer.parseInt(formattedData[1]);
            if (product  != null){
                shop.getWarehouse().addProductInWarehouse(product, count);
            }
        }

    }

    private void buyProductsFromWarehouse(){
        System.out.println("Enter info");
        List<String> tmpString = new LinkedList<>();
        try {
            tmpString = optionalReader.someRead();
        } catch (IOException e) {
            System.err.println("No info entered");
        }
        for (String string: tmpString){
            String[] formattedData = string.split("\\W+");
            Product product = shop.getProducts().get(Integer.parseInt(formattedData[0]));
            int count = Integer.parseInt(formattedData[1]);
            if (product  != null){
                shop.getWarehouse().editProductCountInWarehouse(product, -count);
            }
        }
    }
}
